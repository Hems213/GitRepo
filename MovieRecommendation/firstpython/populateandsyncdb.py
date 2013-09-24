# Run this only once to pupulate db
import pymongo
import csv
import requests

client = pymongo.MongoClient('localhost', 27017)
moviecollection = (client['movie']).moviecollection
print(moviecollection)

with open('..\\MovieLenseResource\\u.item','r') as csvfile:
    rdr = csv.reader(csvfile, delimiter="|")
    for row in rdr:
        titletuple = row[1].rpartition('(')
        title = titletuple[0].rstrip()
        if(',' in title):
            tempTitle = title.partition(', ')
            title = tempTitle[2]+" "+tempTitle[0]
            #correcting typo in a title from data file
            if('Wong Foo' in title):
                title = 'To Wong Foo Thanks for Everything, Julie Newmar'
        year =titletuple[2].rstrip(')')
        if(moviecollection.find_one({'Title':title})!=None):
            continue
        payload = {'t':title,'Y':year,'tomatoes':'true'}
        testurl = 'http://www.omdbapi.com/'
        r = requests.get(testurl, params=payload)
        rjson = r.json()
        if(rjson['Response']=='False'):
            print(rjson)
            print(r.url)
        else:
            moviecollection.insert(rjson)
