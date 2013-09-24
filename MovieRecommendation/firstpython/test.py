from bottle import route, run, get, static_file
import pymongo
from bson.json_util import dumps

client = pymongo.MongoClient('localhost', 27017)
moviecollection = (client['movie']).moviecollection
print(moviecollection.count())



    
@route('/')
def indx():
    return {'result':'type a genre to generate list'}

@get('/<genere>')
def genre(genere='unknown'):
    generes = ['unknown','Action','Adventure','Animation',"Children's",'Comedy','Crime','Documentary','Drama','Fantasy','Film-Noir','Horror','Musical','Mystery','Romance','Sci-Fi','Thriller','War','Western']
    otpt = {}
    otpt['result'] = 'no such genre'
    otpt['validGenres'] = generes
    if(genere in generes):
        reslt=[]
        regexstring = '.*'+genere+'.*'
        for movie in moviecollection.find({"Genre":{'$regex': regexstring, '$options': 'i' }}, sort=[('tomatoRating', -1), ('imdbRating', -1)]):
            reslt.append(dumps(movie))  
        return {'result':reslt}
    else:
        return otpt
#    return otpt#"you are asking for "+genere +" movies"

@get('/static/<filepath:path>')
def resourcefile(filepath):
    return static_file(filepath, root='..\MovieLenseResource')

@get('/favicon.ico')
def favico():
    return ""

run(host='localhost', port=8080, debug=True)
