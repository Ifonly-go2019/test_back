#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define PORT 1234 //端口号
#define BACKLOG	5 //最大连接数量
#define MAXDATASIZE	1000 //缓存区最大长度
typedef struct CLIENT {  //存储客户机信息的结构体
	int fd; //套接字
	char *name; //客户机名称
	struct sockaddr_in addr; //客户机IPv4地址
	char *data; //客户机数据
}CLIENT;
void process_cli(struct CLIENT *client, char *rebuf, int len); //客户信息处理函数
void savedata(char *buf, int len, char *data); //保存数据
void reverse(char buf[]); //反转函数
void caesar(char buf[], char key[]); //凯撒加密函数 

int main(void) {
	int i, maxi, maxfd, sockfd;
	int nready; //已准备好的接口
	ssize_t n; //数据长度
	fd_set rset, allset; //可读字符集， 全部字符集
	//定义套接字，服务器地址信息
	int listenfd, connectfd;
	struct sockaddr_in server;
	struct CLIENT client[FD_SETSIZE]; //客户机的最大接收数量
	char buf[MAXDATASIZE]; //数据缓存区
	int sin_size; //地址长度
	
	//创建TCP套接字
	if((listenfd = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
		//差错处理
		perror("socket() error.\n");
		exit(-1);
	}
	//设置地址首选项，地址重用
	int opt = SO_REUSEADDR;
	setsockopt(listenfd, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt));

	//初始化地址结构，赋值
	bzero(&server, sizeof(server));
	server.sin_family = AF_INET;
	server.sin_port = htons(PORT);
	server.sin_addr.s_addr = htonl(INADDR_ANY);
	
	//绑定套接字
	if(bind(listenfd, (struct sockaddr *)&server, sizeof(struct sockaddr))==-1) {
		perror("bind() error.\n");
		exit(-1);
	}
	//监听并等待连接
	if(listen(listenfd, BACKLOG) == -1) {
		perror("listen() error.\n");
		exit(-1);
	}
	//初始化select（）函数
	sin_size = sizeof(struct sockaddr_in);
	maxfd = listenfd; //监听套接字
	maxi = -1;
	
	//进程中select（）函数可操作的最大文件数量
	for(i = 0; i < FD_SETSIZE; i++)
		client[i].fd = -1;
	FD_ZERO(&allset); //初始化全部可读字符集
	FD_SET(listenfd, &allset); //设置监听套接字为 1
	while(1) {
		struct sockaddr_in addr;
		rset = allset;
		nready = select (maxfd + 1, &rset, NULL, NULL, NULL);
		
		//判断监听套接字是否为 1 
		if(FD_ISSET(listenfd, &rset)) {
			//客户机申请连接
			//服务器接受客户机的请求，建立连接
			if((connectfd = accept(listenfd, (struct sockaddr *)&addr, &sin_size)) == -1) {
				perror("accept() error.\n");
				continue;
			}
			//将得到的套接字添加到client中
			for(i = 0; i < FD_SETSIZE; i++) {
				if(client[i].fd < 0) {
					client[i].fd = connectfd; //保存新的套接字
					client[i].name = malloc(sizeof(char)*MAXDATASIZE); //分配空间
					client[i].addr = addr;
					client[i].data = malloc(sizeof(char)*MAXDATASIZE);
					client[i].name[0] = '\0'; //初始化客户机名称
					client[i].data[0] = '\0'; //初始化客户机数据
					//打印客户机的IP地址以及端口号
					printf("you got a connect from IP: %s, PORT: %d.\n", inet_ntoa(client[i].addr.sin_addr), client[i].addr.sin_port);
					//发送已连接信息给客户机，表示已连接
					send(connectfd, "welcome\n", 22, 0);
					break;
				}
			}
			//超过select（）函数可操作的最大数量
			if(i == FD_SETSIZE)
				printf("too many clients.\n");
			FD_SET(connectfd, &allset); //添加新的描述符
			if(connectfd > maxfd)
				maxfd = connectfd;
			if(i > maxi)
				maxi =i;
			//不存在可读的描述符
			if(--nready <= 0)
				continue;
		}
		//检查所连接的所有的客户机的信息
		for(i = 0; i <= maxi; i++) {
			if((sockfd = client[i].fd) < 0)
				continue;
			if(FD_ISSET(sockfd, &rset)) {
				//接收长度为 0，关闭客户机连接
				if((n = recv(sockfd, buf, MAXDATASIZE, 0)) ==0) {
					close(sockfd);
					//显示是哪一台客户机关闭了连接，并显示客户机发送的所有数据
					printf("client (%s) closed connection.\nuser's data: %s\n", client[i].name, client[i].data);
					FD_CLR(sockfd, &allset);
					client[i].fd = -1;
					//释放空间
					free(client[i].name);
					free(client[i].data);
				}
				else
					process_cli(&client[i], buf, n); //调用客户信息处理函数
				//不存在可读的描述符
				if(--nready <= 0)
					break;
			}
		}
	}
	//关闭监听套接字，释放资源
	close(listenfd);
}

//客户信息处理函数
void process_cli(CLIENT *client, char* buf, int len) {
	buf[len] = '\0';
	//接收客户机的名称并显示
	if(strlen(client->name) == 0) {
		memcpy(client->name, buf, len);
		printf("client's name is %s.\n", client->name);
		return;
	}
	//打印接收到的客户机信息
	printf("received client( %s ) message: %s\n", client->name, buf);
	savedata(buf, len, client->data); //保存客户机数据
	
	printf("%d \n",strlen(buf)-1);
	//恺撒加密
	encry(buf, strlen(buf));
	//打印加密后的数据
	printf("received client( %s )", client->name);
	printf("encryption message:%s\n", buf);
	//将反转后的信息发送给客户机
	send(client->fd, buf, strlen(buf), 0);
}

//数据保存函数
void savedata(char * buf, int len, char *data) {
	int i = 0;
	int data_index = strlen(data); //接收的数据长度
	while(i < len) {
		data[data_index++] = buf[i];
		i++;
	}
	data[data_index++] = ';';//数据分隔标志
	data[data_index] = '\0';
}



//恺撒加密 
void encry(char recvbuf[],int len){
	int secret[10]={2,0,1,7,1,2,2,1,4,9};
	int i,round=0;
       	char sendbuf[MAXDATASIZE];
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
	   recvbuf[i]=sendbuf[i];
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
	   recvbuf[i]=sendbuf[i];
	   
	}

	
}
}
