import pandas as pd
from pprint import pprint
filename = 'Products.txt'
with open(filename, 'r') as f:
    lines = f.readlines()
    headers = lines[0].split('\t')
    print(len(lines))
    for l in lines[1:2]:
        lst = l.split('\t')
#        print(type(lst), type(headers),lst, "\n")
        dic = dict(zip(headers,lst))
        pprint(dic)
