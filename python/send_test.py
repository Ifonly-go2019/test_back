import requests;

if __name__=='__main__':
    payload = {'id': '11111'}
    r = requests.get('http://localhost:8080/sm3_test/servlet/send_test', params=payload)
    r.encoding='utf-8'
    content = r.text
    print(content)