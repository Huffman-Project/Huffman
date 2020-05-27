import matplotlib.pyplot as plt
import numpy as np
import os

x = []
y= []


# Using readlines() 
file1 = open(os.getcwd() + '\\eclipse-workspace\\HuffmanSemiAdaptatif\\src\\charts\\points.txt', 'r') 
Lines = file1.readlines() 
  
count = 0
# Strips the newline character 
for line in Lines: 
    ligne = line.strip()
    
    for i in range(len(ligne)):
        if ligne[i] == ' ':
            taille_texte = ligne[:i]
            taille_binaire = ligne [i+1:]
            x.append(taille_texte)
            y.append(taille_binaire)
file1.close
plt.plot(x, y)

plt.xlabel("taille de texte")
plt.ylabel("taille de code binaire")
plt.title("La compléxité de la méthode semi-adaptatif")

plt.show()



  
  
  


    

    
    
    
    
    