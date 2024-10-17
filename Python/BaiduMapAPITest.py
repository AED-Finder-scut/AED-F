import requests

# 百度地图API的URL
url = "http://api.map.baidu.com/geocoding/v3/"

# 请求参数
params = {
    "address": "广东省广州市华南理工大学大学城校区",
    "output": "json",
    "ak": "api"  # 替换为你的AK
}

# 发送请求
response = requests.get(url, params=params)

# 输出响应结果
if response.status_code == 200:
    print(response.json())
else:
    print(f"请求失败，状态码：{response.status_code}")
