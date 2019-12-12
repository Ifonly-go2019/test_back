import string
import random

n_int = int(input("请输入随机字母个数："))


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


print(random_letters(n_int))

