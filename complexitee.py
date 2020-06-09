import matplotlib.pyplot as mp
import numpy as np
from time import time
from random_word import*
from v import v

x = []
y = []
r = RandomWords()  #Juste un premier teste, je vais la changer par la suite pour avoir une courbe plus précise
z = r.get_random_words( minLength=3, maxLength=30, sortOrder="asc", limit=100)
w = sorted(z, key=len)
for i in range(len(w)):
    debut = time()
    v().coder(str(w[i]))
    duree = (time()-debut)*100
    y.append(duree)
    x.append(len(w[i]))
            
mp.plot(x, y, color='green', linewidth = 1, 
        marker='o', markerfacecolor='blue', markersize=1)
mp.axis([0, 100, 0, 2])
mp.ylim(0,1) 
mp.xlim(0,30) 
mp.xlabel('Taille du texte ') 
mp.ylabel('Temps dexecution')
mp.title('La complexité de Huffman dynamique') 
mp.show()    