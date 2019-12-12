#include <sys/socket.h>
#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>

#define PORT 1234
#define MAXDATASIZE 100


main(){
    int i,n,m;
	int udp_fd;
	struct sockaddr_in server;
	struct sockaddr_in client;
	socklen_t len;

	int num;
	char recev[MAXDATASIZE];
	char get[MAXDATASIZE];

	udp_fd=socket(AF_INET,SOCK_DGRAM,0);
	if(udp_fd==-1)
	{
		printf("socket() create failed");
		exit(1);
	}

	bzero(&server,sizeof(server));
	server.sin_family=AF_INET;
	server.sin_port=htons(PORT);
	server.sin_addr.s_addr=htonl(INADDR_ANY);
	if(bind(udp_fd,(struct sockaddr * )&server,sizeof(server))==-1)
	{
		perror("Bind() error");
		exit(1);
	}

	printf("waiting for client: \n");
	len=sizeof(client);
	while(1){
		num=recvfrom(udp_fd,recev,MAXDATASIZE,0,(struct sockaddr *)&client,&len);
		if(num<0)
		{
			perror("recvfrom error");
			exit(1);
		}

		printf("YOU got a message <%s> from cient.\n  IP:%s. \n  port:%d. \n",recev,inet_ntoa(client.sin_addr),htons(client.sin_port));
         if(num>0){
         printf("receve message is:%s\n",recev);
		 m=num;
		for(i=0;i<m;i++)
		{
			get[num-1]=recev[i];
			num--;
		}
        printf("Exchange message is:\n");
		puts(get);
		sendto(udp_fd,get,m,0,(struct sockaddr *)&client,len );
	} 

		if(!strcmp(recev,"quit"))
			break;		
	}
	close(udp_fd);
}