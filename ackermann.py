#prints out the ackerman function numbers

import time
import numpy as np

def ack(m,n,anot):
    if anot[m,n]>=0:
        return anot
    elif m==0:
        anot[m,n]=n+1
    elif n==0:
        anot=ack(m-1,1,anot)
        anot[m,n]=anot[m-1,1]
    else:
        anot=ack(m,n-1,anot)
        anot=ack(m-1,anot[m,n-1],anot)
        anot[m,n]=anot[m-1,anot[m,n-1]]
    return anot

acks=np.zeros((9999,9999))-1
for m in range(0,4):
    for n in range(0,9):
        ts=time.clock()
        acks=ack(m,n,acks)
        te=time.clock()
        print "Ack({m},{n})={a} took {t}seconds".format(m=m,n=n,a=acks[m,n],t=(te-ts))
