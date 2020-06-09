from noeud import Noeud

# L'algorithme de Vitter en Python sans buffer qui est une autre manière de faire le dynamic Huffman coding
# L'utilisation du buffer impacte le calcule de la complexité 

class v(object):
    def __init__(self):
        super(v, self).__init__()
        self.NYT = Noeud(symbole="NYT") #NYT: not yet transmetted
        self.racine = self.NYT
        self.noeuds = []
        self.a = [None] * 256

    def code(self, s, noeud, code=''):
        if noeud.gauche is None and noeud.droit is None:
            return code if noeud.symbole == s else ''
        else:
            t = ''
            if noeud.gauche is not None:
                t = self.code(s, noeud.gauche, code+'0')
            if not t and noeud.droit is not None:
                t = self.code(s, noeud.droit, code+'1')
            return t

    def trouveNoeud(self, poid):
        for n in reversed(self.noeuds):
            if n.poid == poid:
                return n
    def permuter(self, n1, n2):
        i1, i2 = self.noeuds.index(n1), self.noeuds.index(n2)
        self.noeuds[i1], self.noeuds[i2] = self.noeuds[i2], self.noeuds[i1]

        t_parent = n1.parent
        n1.parent = n2.parent
        n2.parent = t_parent

        if n1.parent.gauche is n2:
            n1.parent.gauche = n1
        else:
            n1.parent.droit = n1

        if n2.parent.gauche is n1:
            n2.parent.gauche = n2
        else:
            n2.parent.droit = n2

    def insert(self, s):
        noeud = self.a[ord(s)]

        if noeud is None:
            b = Noeud(symbole=s, poid=1)
            d = Noeud(symbole='', poid=1, parent=self.NYT.parent,
                gauche=self.NYT, droit=b)
            b.parent = d
            self.NYT.parent = d

            if d.parent is not None:
                d.parent.gauche = d
            else:
                self.racine = d

            self.noeuds.insert(0, d)
            self.noeuds.insert(0, b)

            self.a[ord(s)] = b
            noeud = d.parent

        while noeud is not None:
            l = self.trouveNoeud(noeud.poid)

            if (noeud is not l and noeud is not l.parent and
                l is not noeud.parent):
                self.permuter(noeud, l)

            noeud.poid = noeud.poid + 1
            noeud = noeud.parent

    def symboleParAscii(self, x):
        return chr(int(x, 2))
        
        
        
    def coder(self, texte):
        resultat = ''

        for s in texte:
            if self.a[ord(s)]:
                resultat += self.code(s, self.racine)
            else:
                resultat += self.code('NYT', self.racine)
                resultat += bin(ord(s))[2:].zfill(8)

            self.insert(s)

        return resultat

    

    def decoder(self, texte):
        resultat = ''

        symbole = self.symboleParAscii(texte[:8])
        resultat += symbole
        self.insert(symbole)
        noeud = self.racine

        i = 8
        while i < len(texte):
            noeud = noeud.gauche if text[i] == '0' else noeud.droit
            symbole = noeud.symbole

            if symbole:
                if symbole == 'NYT':
                    symbole = self.symboleParAscii(texte[i+1:i+9])
                    i += 8

                resultat += symbole
                self.insert(symbole)
                noeud = self.racine

            i += 1

        return resultat