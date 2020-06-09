class Noeud(object):
    def __init__(self, parent=None, gauche=None, droit=None, poid=0, symbole=''):
        super(Noeud, self).__init__()
        self._parent = parent
        self._gauche = gauche
        self._droit = droit
        self._poid = poid
        self._symbole = symbole

    @property
    def parent(self):
        return self._parent

    @parent.setter
    def parent(self, parent):
        self._parent = parent

    @property
    def gauche(self):
        return self._gauche

    @gauche.setter
    def gauche(self, gauche):
        self._gauche = gauche

    @property
    def droit(self):
        return self._droit

    @droit.setter
    def droit(self, droit):
        self._droit = droit

    @property
    def poid(self):
        return self._poid

    @poid.setter
    def poid(self, poid):
        self._poid = poid

    @property
    def symbole(self):
        return self._symbole

    @symbole.setter
    def symbole(self, symbole):
        self._symbole = symbole