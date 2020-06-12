import matplotlib.pyplot as mp
import string
import random
from time import time
from random_word import*
from v import v

x = []
y = []
s = []
r=[]
j=3

# on cree une liste qui contient des chaines de caractères avec des lettres aléatoires
 
while j < 100:
    stri = ""
    for i in range(j):
        alphabet = string.ascii_letters
        random_letter = random.choice(alphabet)
        s.append(random_letter)
    r.append(stri.join(s))
    j+=1


# on trouve pour chacune des chaines de caractères le temps qu'il faut pour qu'elle soit codée et décodée

for i in range(len(r)):
    debut = time()
    v().coder(r[i])
    v().decoder(v().coder(r[i]))
    duree = (time()-debut)*10
    y.append(duree)
    x.append(len(r[i]))

# on dessine la courbe
            
mp.plot(x, y, color='blue', linewidth = 1, 
        marker='o', markerfacecolor='blue', markersize=1)
mp.axis([0, 100, 0, 2])
mp.ylim(0,20) 
mp.xlim(0,3000) 
mp.xlabel('Taille du texte ') 
mp.ylabel('Temps dexecution')
mp.title('La complexité de Huffman dynamique') 
mp.show()    