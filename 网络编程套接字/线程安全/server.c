#include <stdio.h>
#include<stdlib.h>
#include<strings.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<pthread.h>
#include<string.h>

#define PORT 1234
#define BACKLOG 5
#define MAXDATASIZE 1000

void process_cli(int connfd,struct sockaddr_in client);
void savedata(char* recvbuf,char* sendbuf,int len,char* cli_data,char* encli_data,int enlen);
void* function(void* arg);
struct ARG
{
    int connfd;
    struct sockaddr_in client;
};
pthread_key_t key;
pthread_once_t once = PTHREAD_ONCE_INIT;
static void destructor(void *ptr)
{
    free(ptr);
}
static void creatkey_once(void)
{
    pthread_key_create(&key,destructor);
}
struct ST_DATA
{
    int index;
    int indexen;
};

void main()
{
    int listenfd,connfd;
    pthread_t tid;
    struct ARG *arg;
    struct sockaddr_in server;
    struct sockaddr_in client;
    socklen_t len;

    if((listenfd = socket(AF_INET,SOCK_STREAM,0)) == -1)
    {
        perror("socket() error.\n");
        exit(1);
    }

    int opt = SO_REUSEADDR;
    setsockopt(listenfd, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt));
    bzero(&server, sizeof(server));
    server.sin_family = AF_INET;
    server.sin_port = htons(PORT);
    server.sin_addr.s_addr = htonl(INADDR_ANY);
    if(bind(listenfd,(struct sockaddr *)&server,sizeof(server)) == -1)
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
        arg = (struct ARG *)malloc(sizeof(struct ARG));
        arg->connfd = connfd;
        memcpy((void *)&arg->client, &client, sizeof(client));
        if(pthread_create(&tid, NULL, function, (void*)arg))
        {
          perror("pthread() error.\n");
          exit(1);
        }
    }
    close(listenfd);
}

void process_cli(int connfd,struct sockaddr_in client)
{
    int num, j, k, num0, x = 0;
    char cli_data[1000], encli_data[1000];
    char recvbuf[MAXDATASIZE], recvbuf1[MAXDATASIZE], sendbuf[MAXDATASIZE], cli_name[MAXDATASIZE];
   
    printf("[!] You got a connection from %s.\n", inet_ntoa(client.sin_addr));
    num = recv(connfd, cli_name, MAXDATASIZE,0);

    if(num == 0)
    {
        close(connfd);
        printf("[!] Client disconnected.\n");
        return;
    }

    cli_name[num-1] = '\0';
    printf("[>] Client's name %s.\n", cli_name);
    while(num = recv(connfd,recvbuf,MAXDATASIZE,0))
    {
        recvbuf[num] = '\0';
        num0 = num;
        printf("[>] Recevied client(%s) message:%s", cli_name,recvbuf);
/*
        for(x = 0; x < num; x++)
        {
            recvbuf1[x] = recvbuf[x];
        }

        if((j = (num-1)%10) != 0)
        {
            for(k = 0; k < (10-j); k++)
            {
                recvbuf[num-1] = '0';
                num++;
            }
        }
*/   
        

        encry(recvbuf,sendbuf,strlen(recvbuf)-1);
	int keynum;
	keynum=strlen(sendbuf);
        sendbuf[keynum] = '\0';
	printf("recvbuf  is %s: \n",recvbuf);
	printf("sendvbuf is %s: \n",sendbuf);
        savedata(recvbuf, sendbuf, num0, cli_data, encli_data, num);
        send(connfd, sendbuf, strlen(sendbuf), 0);
        printf("[>] Send message:%s\n", sendbuf);

        if(!strcmp(sendbuf, "suja000000"))
        {
            printf("[!] Client (%s) quit.\n\n", cli_name);
            close(connfd);
            printf("[>] Client(%s) closed connection.\n User's data %s\n", cli_name, cli_data);
           
            break;
        }
	int d;
	for(d=0;d<strlen(sendbuf);d++)
	{
	  sendbuf[d]="0";
	}
	
    }
    close(connfd);
}

void* function(void* arg)
{
    struct ARG *info;
    info = (struct ARG*)arg;
    process_cli(info->connfd,info->client);
    free(arg);
    pthread_exit(NULL);
}

void savedata(char* recvbuf, char* sendbuf, int len, char* cli_data,char* encli_data, int enlen)
{
    struct ST_DATA *data;
    pthread_once(&once, creatkey_once);
    if((data = (struct ST_DATA *)pthread_getspecific(key)) == NULL)
    {
        data = (struct ST_DATA *)malloc(sizeof(struct ST_DATA));
        pthread_setspecific(key,data);
        data->index = 0;
        data->indexen = 0;
    }
    int i = 0;
    while(i < len-1)
    {
        cli_data[data->index++] = recvbuf[i];
        i++;
    }
    cli_data[data->index] = '\0';
    i = 0;
    while(i < enlen-1)
    {
        encli_data[data->indexen++] = sendbuf[i];
        i++;
    }
    encli_data[data->indexen] = '\0';
}

void encry(char recvbuf[],char sendbuf[],int len){
	int secret[10]={2,0,1,7,1,2,2,1,4,9};
	int i,round=0;
       
        int num=(len%10+10)%10;

      if(len<11){
	for(i=len;i<=10;i++){
	  recvbuf[i]='0';	
	}
	recvbuf[10] = '\0'; 
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

