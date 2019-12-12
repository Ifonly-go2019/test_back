#include <sys/socket.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>

#define PORT 1234
#define BACKLOG 1

int main()
{

	int i,n,m;
    int ser_confd;
	const int MAXBUF = 256;
    char buffer[MAXBUF];
	char get[MAXBUF];

	int server_lsfd=socket(AF_INET,SOCK_STREAM,0);
	struct sockaddr_in ser;
	struct sockaddr_in cli;
	socklen_t addrlen;
	if (server_lsfd<0)
	{
	  perror("can't create socket()");	
	  exit(1);
	}
	printf("created socket, server_fd: %d\n", server_lsfd);


	int opt=SO_REUSEADDR;
	setsockopt(server_lsfd,SOL_SOCKET,SO_REUSEADDR,&opt,sizeof(opt));
    bzero(&ser,sizeof(ser));
	ser.sin_family=AF_INET;
	ser.sin_port=htons(PORT);
	ser.sin_addr.s_addr=htonl(INADDR_ANY);

	if(bind(server_lsfd,(struct sockaddr *)&ser,sizeof(ser))<0){
		perror("bind failed");
        return 0;
	}
	printf("bind complete, port number: %d\n", ntohs(ser.sin_port));



	if(listen(server_lsfd,BACKLOG)==-1){
		perror("listen failed");
        exit(1);
	}

	 printf("socket listen, server_fd: %d\n", server_lsfd);


	int cli_len=sizeof(cli);
	if((ser_confd=accept(server_lsfd,(struct sockaddr *)&cli,&addrlen))==-1)
	{
		perror("accept() failed");
        exit(1);
	}

	printf("YOU got a connection from client's ip is %s,port is   %d\n",inet_ntoa(cli.sin_addr),ntohs(cli.sin_port));


	n = read(ser_confd, buffer, MAXBUF);
    while(n>0){
	    printf("client %s's message is:\n",inet_ntoa(cli.sin_addr));
        puts(buffer);

        if(!strcmp(buffer,"quit"))
        break;
		
		m=n;
		n--;
		for(i=0;i<m-1;i++)
		{
			get[n-1]=buffer[i];
			n--;
		}
		get[m-1]='\0';
        printf("Exchange message is:\n");
		puts(get);
		write(ser_confd,get,m);
	} 

	close(server_lsfd);
    close(ser_confd);
}