import turtle
def drawSnake(rad, angle, len, neckrad):
    for i in range(len):
        turtle.circle(rad, angle)
        turtle.circle(-rad, angle)
    turtle.circle(rad, angle/2)
    turtle.fd(rad)
    turtle.circle(neckrad+1, 180)
    turtle.fd(rad*2/3)

def main() :
    turtle.setup(1300, 800, 0, 0)
    pythonsize = 10
    turtle.pensize(pythonsize)
    turtle.pencolor("red")
    turtle.seth(-40)  #运行方向
    drawSnake(20, 20, 5, pythonsize/2)

main()