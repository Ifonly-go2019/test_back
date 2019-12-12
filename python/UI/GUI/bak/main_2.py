# coding=utf-8

import sys,os
import time

import cgitb
cgitb.enable( format = 'text')

from PyQt5 import QtCore, QtGui, uic, QtWidgets

from PyQt5.QtCore import *
from PyQt5.QtGui import *
from PyQt5.QtWidgets import *
from numpy import *

from matplotlib.backends.backend_qt5agg import FigureCanvasQTAgg as FigureCanvas
from matplotlib.figure import Figure
import matplotlib.pyplot as plt
import matplotlib as mpl

import Test

# 一个主界面、一个进度条界面
Ui_MainWindow, QtBaseClass_0 = uic.loadUiType(".\GUI\main.ui")
Ui_Progress, QtBaseClass_1 = uic.loadUiType(".\GUI\Progress.ui")


mpl.rcParams['font.sans-serif']=['SimHei'] #指定默认字体 SimHei为黑体
mpl.rcParams['axes.unicode_minus']=False #用来正常显示负号
# *******************************
# **********   绘图
# *******************************
class PlotCanvas(FigureCanvas):

    def __init__(self, parent=None, width=5, height=4, dpi=100):
        fig = Figure(figsize=(width, height), dpi=dpi)
        self.axes = fig.add_subplot(111)
        FigureCanvas.__init__(self, fig)
        self.setParent(parent)
        FigureCanvas.setSizePolicy(self,
                                   QSizePolicy.Expanding,
                                   QSizePolicy.Expanding)
        FigureCanvas.updateGeometry(self)
        self.init_plot()#打开App时可以初始化图片

    def init_plot(self):
        x = ['']
        y = ['']
        self.axes.plot(x, y)

    def update_figure(self,x,y):
        self.axes.cla()
        self.axes.set_xlabel('')
        self.axes.set_ylabel('Y轴')
        self.axes.plot(x, y)
        self.draw()

# *******************************
# **********   主界面
# *******************************
class MyApp(QtWidgets.QMainWindow, Ui_MainWindow):
    def __init__(self):
        QtWidgets.QMainWindow.__init__(self)
        Ui_MainWindow.__init__(self)
        self.setupUi(self)
        # 设置标题（在使用了QT Designer 设计好以后可以这么使用）
        self.setWindowTitle('Main')
        # 全屏
        # self.showMaximized()

        # 链接窗口和画图
        # 初始化这个加载显示图
        Position = self.frame_2.geometry()
        self.LINE = PlotCanvas(self.frame_2)
        self.gridLayout_4.addWidget(self.LINE, 0, 0, 1, 1)

        # 按钮操作
        self.OpenButton.clicked.connect(self.OpenImage)
        self.ProcessButton.clicked.connect(self.Start_Thread)

        # 连接子进程的信号和槽函数
        self.SingleThread = Single_Thread()
        self.SingleThread.Finish_Signal.connect(self.Finish_Single)

        self.InitButtons_1()
        self.InitButtons_2()

        self.Group1_Click = 0
        self.Group2_Click = 0

    #设置显示图片
    def showpic(self,filename):
        #调用QtGui.QPixmap方法，打开一个图片，存放在变量png中
        png=QPixmap(filename)
        Position = self.pic_label_1.geometry()
        scaredPixmap = png.scaled(Position.width(),
                                  Position.height(),
                                  # aspectRatioMode=Qt.KeepAspectRatio)
                                  aspectRatioMode=Qt.IgnoreAspectRatio)
        self.pic_label_1.setPixmap(scaredPixmap)

    # 关闭主窗口操作
    def closeWindow(self):
        self.close()

    # 关闭窗口的提示
    def closeEvent(self, event):
        box = QtWidgets.QMessageBox()
        Messages_S = "是否退出？"
        Messages_S = Messages_S
        reply = box.warning(self, '退出程序', Messages_S, box.Yes | box.No, box.Yes)
        if reply == box.Yes:
            event.accept()
        else:
            event.ignore()

    # 打开警告弹窗
    def OpenWarningBox(self, Messages_S):
        box = QtWidgets.QMessageBox()
        Messages_S = Messages_S
        box.warning(self, '警告', Messages_S, box.Ok)

    # 打开图片
    def OpenImage(self):
        filenames = QFileDialog.getOpenFileName(self, "Choose TXT", "", "txt files(*.txt);;All files(*.*)")
        if len(filenames[0]) > 0:
            self.filename = filenames[0]
            # self.showpic(self.filename)
            self.Read_TxT(self.filename)

    # 绘图并且显示
    def Read_TxT(self,filename):

        A = zeros((1, 502), dtype=float)  # 先创建一个 1*502的全零方阵A，并且数据的类型设置为float浮点型
        f = open(filename)  # 打开数据文件文件
        lines = f.readlines()  # 把全部数据文件读到一个列表lines中
        A_row = 0  # 表示矩阵的行，从0行开始
        list = []
        for line in lines:  # 把lines中的数据逐行读取出来
            list = line.strip('\n').split(' ')  # 处理逐行数据：strip表示把头尾的'\n'去掉，split表示以空格来分割行数据，然后把处理后的行数据返回到list列表中
            A[A_row:] = list[0:502]  # 把处理后的数据放到方阵A中。list[0:502]表示列表的第0行数据放到矩阵A中的A_row行，一共502位数字
            A_row += 1  # 然后方阵A的下一行接着读
            # print(line)
        list_x = [x for x in range(502)]
        # return(list_x, list)
        list_y = []
        for m in list:
            list_y.append(float((m.strip("'"))))
        self.LINE.update_figure(list_x, list_y)

    # 开始识别
    def Start_Thread(self):
        self.OUTPUT.clear()
        self.SingleThread.start()
        # 必须放到最后一条，因为底下的代码不会执行
        Progress_window.exec_()

    # 结束识别后需要显示的图片和结果
    def Finish_Single(self,Result):
        # 关闭进度条窗口
        Progress_window.close()
        self.OUTPUT.append(Result)

    # 单选框
    def InitButtons_1(self):
        self.Group1 = QButtonGroup(self)
        self.Group1.addButton(self.radioButton_1,1)
        self.Group1.addButton(self.radioButton_2,2)
        self.Group1.addButton(self.radioButton_3,3)


        self.Group1.buttonClicked.connect(self.Group1Clicked)

    def Group1Clicked(self):
        sender = self.sender()
        if sender == self.Group1:
            if self.Group1.checkedId() >= 1 and self.Group1.checkedId() <= 3:
                self.Group1_Click = self.Group1.checkedId()


    # 单选框
    def InitButtons_2(self):
        self.Group2 = QButtonGroup(self)
        self.Group2.addButton(self.radioButton_4,1)
        self.Group2.addButton(self.radioButton_5,2)
        self.Group2.buttonClicked.connect(self.Group2Clicked)

    def Group2Clicked(self):
        sender = self.sender()
        if sender == self.Group2:
            if self.Group2.checkedId() >= 1 and self.Group1.checkedId() <= 2:
                self.Group2_Click = self.Group2.checkedId()


# *******************************
# **********   进度条窗口
# *******************************
class Progress_Dialog(QtWidgets.QDialog, Ui_Progress):
    def __init__(self):
        QtWidgets.QDialog.__init__(self)
        Ui_Progress.__init__(self)
        self.setupUi(self)
        # 设置标题（在使用了QT Designer 设计好以后可以这么使用）
        # 无边框效果以及窗口前置效果
        self.setWindowFlags(QtCore.Qt.FramelessWindowHint)
        self.setWindowOpacity(0.9)

    # **********   关闭窗口的提示
    def closeEvent(self, event):
        event.accept()


# *************************************
# ********** 多线程任务
# *************************************
class Single_Thread(QThread):
    # 结束信号
    Finish_Signal = pyqtSignal(str)
    def __init__(self, parent=None):
        super(Single_Thread, self).__init__(parent)

    def run(self):
        data = []
        data.append(window.lineEdit_1.text())
        data.append(window.lineEdit_2.text())
        data.append(window.lineEdit_3.text())
        data.append(window.lineEdit_4.text())

        data.append(window.Group1_Click)
        data.append(window.Group2_Click)

        data.append(window.textEdit_2.toPlainText())
        data.append(window.textEdit_3.toPlainText())
        data.append(window.textEdit_4.toPlainText())
        data.append(window.textEdit_5.toPlainText())
        data.append(window.textEdit_6.toPlainText())
        data.append(window.textEdit_7.toPlainText())
        data.append(window.textEdit_8.toPlainText())
        data.append(window.textEdit_9.toPlainText())
        data.append(window.textEdit_10.toPlainText())
        data.append(window.textEdit_11.toPlainText())

        ret = Test.UpLoad(data)
        # 将结果发送给主界面
        self.Finish_Signal.emit(ret)


# 这段主程序创建了一个新的 Qt Gui 应用。，每个 QT 应用都可以通过命令行进行配置，所以必须传入sys.argv 参数。
if __name__ == "__main__":

    app = QtWidgets.QApplication(sys.argv)
    Progress_window = Progress_Dialog()
    window = MyApp()
    window.show()

    sys.exit(app.exec_())
