# coding=utf-8
import sys,os
import time
import requests

import main




# 上传数据的代码
def UpLoad(data):
    # 里面的参数和你的服务器参数对应起来就行了

    #         data.append(window.lineEdit_1.text())
    #         data.append(window.lineEdit_2.text())
    #         data.append(window.lineEdit_3.text())
    #         data.append(window.lineEdit_4.text())
    #
    #         data.append(window.Group1_Click) # 前一个单选框的值
    #         data.append(window.Group2_Click) # 后一个单选框的值
    #
    #         data.append(window.textEdit_2.toPlainText())
    #         data.append(window.textEdit_3.toPlainText())
    #         data.append(window.textEdit_4.toPlainText())
    #         data.append(window.textEdit_5.toPlainText())
    #         data.append(window.textEdit_6.toPlainText())
    #         data.append(window.textEdit_7.toPlainText())
    #         data.append(window.textEdit_8.toPlainText())
    #         data.append(window.textEdit_9.toPlainText())
    #         data.append(window.textEdit_10.toPlainText())
    #         data.append(window.textEdit_11.toPlainText())

    payload = {'Sfirst': str(data[0]),




               'samples':str(data[1]),
               'Tfirst': str(data[2]),
               'traces': str(data[3]),
               'rounds': str(data[4]),
               'step': str(data[5]),
               'x1': str(data[6]),
               'y1': str(data[7]),
               'x2': str(data[8]),
               'd2': str(data[9]),
               'y2': str(data[10]),
               'h2': str(data[11]),
               'c3': str(data[12]),
               'd3': str(data[13]),
               'g3': str(data[14]),
               'h3': str(data[15]),
               'step_final': str(data[16]),
               }
    r = requests.get('http://localhost:8080/sm3_test/sm3_test', params=payload)
    r.encoding = 'utf-8'
    content = r.text
    print(content)
    return content

#def msg():

 #   a = requests.form.get('selected')

  #  print ('selected:', requests.data)