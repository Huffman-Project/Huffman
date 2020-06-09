from noeud import Noeud

# L'algorithme de Vitter en Python sans buffer qui est une autre manière de faire le dynamic Huffman coding
# L'utilisation du buffer impacte le calcule de la complexité 

class Vitter(object):
    def __init__(self):
        super(Vitter, self).__init__()
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