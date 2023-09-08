from docx_parser import DocumentParser
import sqlite3


INFILE = 'src/A1.docx'
SQLFILE = 'src/tickets.db'
TABLENAME = 'A1'


db = sqlite3.connect(SQLFILE)
cursor = db.cursor()


cursor.execute(
    'CREATE TABLE ' + TABLENAME + ' (' +
    ' ticketNum VARCHAR (50),' + 
    ' questionNum VARCHAR (50),' +
    ' questionText VARCHAR (2000),' +
    ' rightAnswer VARCHAR (50),' +
    ' comment VARCHAR (2000),' +
    ' pic BLOB' +
    ')'
    )

cursor.execute(
    'CREATE TABLE ' + TABLENAME + '_answ (' +
    ' ticketNum VARCHAR (50),' + 
    ' questionNum VARCHAR (50),' +
    ' answerNum VARCHAR (50),' +
    ' answerText VARCHAR (2000)' +
    ')'
    )
db.commit()

doc = DocumentParser(INFILE)
txt = doc.parse()

def processQuestion(raw: list) -> list:
    proc = dict()

    proc['ticketNum'] = (
        raw[0]
        .split(' ')[1]
        .replace('.', '')
        )

    proc['questionNum'] = (
        raw[2]
        .split('.')[0]
        )

    proc['questionText'] = (
        raw[2]
        .split('.')[1]
        )
    
    if proc['questionText'].startswith(' '):
        proc['questionText'] = proc['questionText'][1:]

    proc['rightAnswer'] = raw[4]    

    proc['comment'] = raw[5]

    with open(f'src\\A1_pics\\{pic}.jpg', 'rb') as f:
        proc['pic'] = f.read()

    proc['answers'] = (
        raw[3]
        .split('\n')
    )

    numz = ['0', '1', '2', '3', '4', 
               '5', '6', '7', '8', '9',
               '.', ' ']
    
    

    for ans in proc['answers']:
        pos = proc['answers'].index(ans)
        while ans[0] in numz:
            ans = ans[1:]
        
        proc['answers'][pos] = ans

    print(proc['answers'])

    return proc


# Parse
try:
    for _, item in txt:
        data = item['data']

except(IndexError):
    pass

data.pop(0)

for line in data:
    f = processQuestion(line)
    data_main = (f['ticketNum'],
            f['questionNum'], 
            f['questionText'], 
            f['rightAnswer'], 
            f['comment'],
            f['pic']
            )
    
    data_answ = (
       (f['ticketNum'], f['questionNum'], f['answers'].index(i)+1, i) for i in f['answers']
    )

    data_answers = list(data_answ)

    cursor.execute(
        'INSERT INTO ' + TABLENAME +
        ' VALUES(?, ?, ?, ?, ?, ?)',
        data_main
    )

    for ans in data_answers:
        cursor.execute(
            'INSERT INTO ' + TABLENAME + '_answ' +
            ' VALUES (?, ?, ?, ?)',
            ans
        )
    db.commit()
db.close()

