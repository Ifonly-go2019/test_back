#include <sys/socket.h>
#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <netdb.h>


#define PORT 1234
#define MAXDATASIZE 100


int main(int argc,char *argv[])
{
	int cli_lsfd,num;
    int i=0;
    char buf[MAXDATASIZE]; 
	char send[MAXDATASIZE];
    char get[MAXDATASIZE];
	struct sockaddr_in server;
	struct hostent  *he;

	if(argc!=2){
	printf("Usage:%s<IP Address>\n",argv[0]);
	exit(1);
	}

	if((he=gethostbyname(argv[1]))<0){
	printf("IP error");
    exit(1);
	}

	cli_lsfd=socket(AF_INET,SOCK_STREAM,0);
	if(cli_lsfd==-1){
	printf("socket() error");
	exit(1);
	}


	bzero(&server,sizeof(server));
	server.sin_family=AF_INET;
	server.sin_port=htons(PORT);
	server.sin_addr=*(struct in_addr *)he->h_addr;

	if(connect(cli_lsfd,(struct sockaddr *)&server,sizeof(server))==-1){
	printf("connect error");
	exit(1);
	}

    printf("connect success\n"); 
    printf("need to input \n"); 
    gets(send);

    int writenum=write(cli_lsfd,send,strlen(send)+1);
	if(writenum<0){
	printf("write() error");
	exit(1);
	  }

	num=read(cli_lsfd,get,MAXDATASIZE);
	if(num<0){
	printf("recv() error");
    exit(1);
	}

	get[num-1]="\0";
	printf("server message:%s\n",get);
	close(cli_lsfd);

}











