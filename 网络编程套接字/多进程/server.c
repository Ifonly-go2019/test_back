#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<arpa/inet.h>

#define PORT 1234
#define BACKLOG 5
#define MAXDATASIZE 1000

void process_cli(int connfd,struct sockaddr_in client);
int main()
{
    int listenfd,connfd;
    pid_t pid;
    struct sockaddr_in server;
    struct sockaddr_in client;
    int len;
    if((listenfd = socket(AF_INET,SOCK_STREAM,0)) == -1)
    {
        perror("socket() error.\n");
        exit(1);
    }
    int opt = SO_REUSEADDR;
    setsockopt(listenfd, SOL_SOCKET, SO_REUSEADDR, &opt,sizeof(opt));
    bzero(&server, sizeof(server));
    server.sin_family = AF_INET;
    server.sin_port = htons(PORT);
    server.sin_addr.s_addr = htonl(INADDR_ANY);
    if(bind(listenfd, (struct sockaddr *)&server, sizeof(server)) == -1)
    {
        perror("bind() error.\n");
        exit(1);
    }
    if(listen(listenfd,BACKLOG)==-1)
    {
        perror("listen() error.\n");
        exit(1);
    }
    len = sizeof(client);
    while(1)
    {
        if((connfd = accept(listenfd, (struct sockaddr *)&client,&len)) == -1)
        {
            perror("accept() error.\n");
            exit(1);
        }
        if((pid = fork()) > 0)
        {
            close(connfd);
            continue;
        }
        else if(pid == 0)
        {
            close(listenfd);
            process_cli(connfd,client);
            exit(1);
        }
        else
        {
            printf("fork() error.\n");
            exit(1);
        }
    }
    close(listenfd);
    return 0;
}

void process_cli(int connfd, struct sockaddr_in client)
{
    int num, i = 0;
    char recvbuf[MAXDATASIZE], sendbuf[MAXDATASIZE], cli_name[MAXDATASIZE];
    printf("[!] You got a connection from IP:%s, PORT:%d\n", inet_ntoa(client.sin_addr), ntohs(client.sin_port));
    num = recv(connfd, cli_name, MAXDATASIZE,0);
    if(num == 0)
    {
        close(connfd);
        printf("Client disconnected.\n");
        return ;
    }
    cli_name[num-1] = '\0';
    printf("[>] Client's name is %s.\n", cli_name);
    while(num = recv(connfd, recvbuf, MAXDATASIZE,0))
    {  
  	
        
        printf("[>] Received client(%s) message:%s", cli_name, recvbuf);
	printf("NUMBERI IS:%d \n",num-1);
        

        encry(recvbuf,sendbuf,num-1);   
	//recvbuf[num] = '\0';
        printf("change message is:%s \n",sendbuf);
        
        //sendbuf[num] = '\0';
        send(connfd, sendbuf, strlen(sendbuf), 0);
	
    }
    
    close(connfd);
}


void encry(char recvbuf[],char sendbuf[],int len){
	int secret[10]={2,0,1,7,1,2,2,1,4,9};
	int i,round=0;
       
        int num=(len%10+10)%10;

      if(len<11){
	for(i=len;i<=10;i++){
	  recvbuf[i]='0';	
	}
         for(i=0;i<10;i++){
	 round=(i%10+10)%10;
	  if(recvbuf[i] >= 'A' && recvbuf[i] <= 'Z')
	 {
          recvbuf[i]=((recvbuf[i]-'A')+secret[round])%26+'A';
	 
	 }

	  else if(recvbuf[i] >= 'a' && recvbuf[i] <= 'z')
	 {
          recvbuf[i]=((recvbuf[i]-'a')+secret[round])%26+'a';	  
	 }
         else {
	 recvbuf[i]=recvbuf[i];
	}
	   sendbuf[i]=recvbuf[i];
	   
	}
	}


	else if(len>=10){
	
	int k=len/10;
	for(i=len;i<(k+1)*10;i++){
	  recvbuf[i]='0';
	 }	
	  
	  for(i=0;i<len;i++){
	   round=(i%10+10)%10;
	  if(recvbuf[i] >= 'A' && recvbuf[i] <= 'Z')
	 {
          recvbuf[i]=((recvbuf[i]-'A')+secret[round])%26+'A';
	 
	 }

	  else if(recvbuf[i] >= 'a' && recvbuf[i] <= 'z')
	 {
          recvbuf[i]=((recvbuf[i]-'a')+secret[round])%26+'a';	  
	 }
         else {
	 recvbuf[i]=recvbuf[i];
	}
	   sendbuf[i]=recvbuf[i];
	   recvbuf[i]='\0';
	}

	
	}
      
}
 
 

