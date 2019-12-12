#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>

#define PORT 1234 //端口号
#define MAXDATASIZE	1000 //数据缓冲区长度

int main(int argc, char *argv[]) {
	//定义相关变量
	int sockfd, num;
	char   buf[MAXDATASIZE];
	struct hostent * he;
	struct sockaddr_in server;
	int i=1;
	
	//检查用户的输入是否合理
	if(argc != 2) {
		printf("usage: %s  <IP address>\n", argv[0]);
		exit(-1);
	}
	//获取主机信息
	if((he = gethostbyname(argv[1])) == NULL) {
		perror("gethostbyname() error.\n");
		exit(-1);
	}
	//创建TCP套接字
	if((sockfd = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
		perror("socket() error.\n");
		exit(1);
	}
	//初始化地址结构并赋值
	bzero(&server, sizeof(server));
	server.sin_family = AF_INET;
	server.sin_port = htons(PORT);
	server.sin_addr = *((struct in_addr *) he->h_addr);

	//连接服务器
	if(i = connect(sockfd, (struct sockaddr *)&server, sizeof(struct sockaddr)) == -1) {
		perror("connect() error.\n");
		exit(1);
	}

	//接受服务器发送的已连接信息
	if((num = recv(sockfd, buf, MAXDATASIZE, 0)) == -1) {
		perror("recv() error.\n");
		exit(1);
	}

	//打印已连接信息，即服务器发送来的数据信息
	buf[num] = '\0';
	printf("server message: %s",buf);
	//输入客户机的名称
	printf("please input your name:");
	scanf("%s",buf);
	//将客户机的名称发送给服务器
	if((num = send(sockfd, buf, strlen(buf), 0)) == -1) {
		perror("send() error.\n");
		exit(1);
	}
	while(1) {
		//输入要发送的信息
		printf("please input message:");
		scanf("%s", buf);
		
		//若输入为“quit",则与服务器断开连接
		if(!strcmp(buf,"quit"))
            break;
		else {
			//发送数据给服务器
			send(sockfd, buf, strlen(buf), 0);
			bzero(buf, sizeof(buf));
			//接受服务器处理后返回的信息并打印
			recv(sockfd, buf, MAXDATASIZE, 0);
			printf("encyprtion message: %s.\n", buf);
		}
	}
	//释放资源
	close(sockfd);
}