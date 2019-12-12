import copy
import struct
import binascii
import hashlib
import string
import random

F32 = 0xFFFFFFFF
# 这些常量是对自然数中前64个质数的立方根的小数部分取前32bit而来。
_k = [0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5,
      0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
      0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3,
      0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
      0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc,
      0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
      0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7,
      0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
      0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13,
      0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
      0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3,
      0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
      0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5,
      0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
      0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208,
      0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2]

_h = [0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a,
      0x510e527f, 0x9b05688c, 0x1f83d9ab, 0x5be0cd19]


def _pad(msglen):
    mdi = msglen & 0x3F
    length = struct.pack('!Q', msglen << 3)

    if mdi < 56:
        padlen = 55 - mdi
    else:
        padlen = 119 - mdi

    return b'\x80' + (b'\x00' * padlen) + length#填充块算法，b'\x80'执行填充块+1操作

#定义所需使用算法函数
def _rotr(x, y):
    return ((x >> y) | (x << (32 - y))) & F32


def _maj(x, y, z):
    return (x & y) ^ (x & z) ^ (y & z)


def _ch(x, y, z):
    return (x & y) ^ ((~x) & z)


class SHA256:
    _output_size = 8
    blocksize = 1
    block_size = 64
    digest_size = 32

    def __init__(self, m=None):         #初始化输入的消息，即为m
        self._counter = 0
        self._cache = b''
        self._k = copy.deepcopy(_k)
        self._h = copy.deepcopy(_h)     #每次运算对全局变量复制一次，不破坏原变量

        self.update(m) #把message送到update函数里面

    def _compress(self, c):  #^为异或符号
        w = [0] * 64
        w[0:16] = struct.unpack('!16L', c)

        for i in range(16, 64):
            s0 = _rotr(w[i - 15], 7) ^ _rotr(w[i - 15], 18) ^ (w[i - 15] >> 3)
            s1 = _rotr(w[i - 2], 17) ^ _rotr(w[i - 2], 19) ^ (w[i - 2] >> 10)
            w[i] = (w[i - 16] + s0 + w[i - 7] + s1) & F32
        # 划分为16个字节
        a, b, c, d, e, f, g, h = self._h

        for i in range(64):      #>>为右移操作
            s0 = _rotr(a, 2) ^ _rotr(a, 13) ^ _rotr(a, 22)
            t2 = s0 + _maj(a, b, c)
            s1 = _rotr(e, 6) ^ _rotr(e, 11) ^ _rotr(e, 25)
            t1 = h + s1 + _ch(e, f, g) + self._k[i] + w[i]

            h = g
            g = f
            f = e
            e = (d + t1) & F32
            d = c
            c = b
            b = a
            a = (t1 + t2) & F32 #将输入数据进行64轮运算，再打乱

        for i, (x, y) in enumerate(zip(self._h, [a, b, c, d, e, f, g, h])): #enumerate为枚举，让i以及（x.y）组成一个元组
            self._h[i] = (x + y) & F32 #再次带入运算，赋值给(x,y)

    def update(self, m):
        if not m:
            return

        self._counter += len(m) #初始化变量，加上长度
        m = self._cache + m

        for i in range(0, len(m) // 64): #//表示向下取整，给返回值分块
            self._compress(m[64 * i:64 * (i + 1)]) #传入compress函数，加上长度值
        self._cache = m[-(len(m) % 64):]  #重新排序

    def digest(self):
        r = copy.deepcopy(self)
        r.update(_pad(self._counter))
        data = [struct.pack('!L', i) for i in r._h[:self._output_size]]
        return b''.join(data) #生成数组，把分块加入空二进制字符串中

    def hexdigest(self):
        return binascii.hexlify(self.digest()).decode('ascii') #以ascii码转化成16进制

def random_letters(n):
    # 定义一个空列表保存随机字母
    letters_list = []
    while len(letters_list) < n :
        a_str = string.ascii_lowercase
        # 字母：string.ascii_letters
        # 大写：string.ascii_uppercase
        # 小写：string.ascii_lowercase
        random_letter = random.choice(a_str)
        if (random_letter not in letters_list) :
            letters_list.append(random_letter)
        else:
            pass
    # 将列表转换成字符串输出
    letters_list1 =[str(i) for i in letters_list]
    letters_list2=''.join(letters_list1)
    return letters_list2

def true_sha256(message):
    m = hashlib.sha256()
    m.update(message)
    return m.hexdigest()


def my_sha256(message):
    return SHA256(message).hexdigest()


if __name__ == '__main__':
    out = ''
    total_1 = 0
    total_0 = 0
    n_int = int(input("请输入随机字母个数："))

    for i in range(1):

        message = random_letters(n_int)
        print("输入的随机字母是：",random_letters(n_int))
        print('my_sha256 result is: ', my_sha256(bytes(message, encoding="utf8")), '\n', 'lib_sha256 result is: ',
              true_sha256(bytes(message, encoding="utf8")), sep='')
        assert true_sha256(bytes(message, encoding="utf8")) == my_sha256(bytes(message, encoding="utf8"))
        out += my_sha256(bytes(message, encoding="utf8"))

        a = binascii.unhexlify(my_sha256(bytes(message, encoding="utf8")))
        res = int.from_bytes(a, byteorder='big', signed=False)
        r_1 = bin(res)[2:].count('1')
        r_0 = bin(res)[2:].count('0')
        total_1 += r_1
        total_0 += r_0

    print('The final output is : ' + out)
    print('1的个数%d,0的个数%d' % (total_0, total_1))
