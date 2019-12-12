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

main(int argc,char *argv[]){
	int sockfd,num;
	char buf[MAXDATASIZE];
	char send[MAXDATASIZE];
	struct hostent *he;
	struct sockaddr_in server,peer;


	if(argc!=2){
		printf("Usage:%s <IP ADDRESS><message>\n",argv[0]);
		exit(1);
	}

	if((he=gethostbyname(argv[1]))<0){
		printf("gethostbyname() error \n");
		exit(1);
	}

	if((sockfd=socket(AF_INET,SOCK_DGRAM,0))==-1){
		printf("sockeet() error");
		exit(1);
	}

	bzero(&server,sizeof(server));
	server.sin_family=AF_INET;
	server.sin_port=htons(PORT);
	server.sin_addr=*(struct in_addr*)he->h_addr;


	printf("connect success\n"); 
    printf("need to input \n"); 
    gets(send);

	sendto(sockfd,send,strlen(send),0,(struct sockaddr * )&server,sizeof(server));
	socklen_t len;
	len=sizeof(server);
	while(1){
		if((num=recvfrom(sockfd,buf,MAXDATASIZE,0,(struct sockaddr * )&peer,&len))==-1)
		{
			printf("recvfrom() error ");
			exit(1);
		}

		if(len!=sizeof(server)||memcmp((const void *)&server,(const void *)&peer,len)!=0){
			printf("Receive message from other server \n");
			continue;
		}
		printf("server message is : %s \n",buf);
		break;
	}
	close(sockfd);
}









