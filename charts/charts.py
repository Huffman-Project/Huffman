import math
import matplotlib.pyplot as plt
import numpy as np
import os


x1 = []
y1 = []




# Using readlines() 
file1 = open(os.getcwd() + '\\eclipse-workspace\\HuffmanSemiAdaptatif\\src\\charts\\points.txt', 'r') 
Lines1 = file1.readlines() 

  
# Strips the newline character 
for line in Lines1: 
    ligne = line.strip()
    
    for i in range(len(ligne)):
        if ligne[i] == ' ':
            taille_texte = ligne[:i]
            taille_binaire = ligne [i+1:]
            x1.append(taille_texte)
            y1.append(taille_binaire)
file1.close



plt.plot(x1, y1)

#####################################################################



plt.xlabel("taille de texte")
plt.ylabel("temps d'execution")
plt.title("La compléxité de huffman semi-adaptatif")

plt.show()



  
  
  


    

    
    
    
    
    