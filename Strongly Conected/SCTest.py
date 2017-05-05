from SC import *

# Creamos un grafo con su lista de adyacencia
g1 = Grafo(5)
g1.addEdge(0, 1)
g1.addEdge(1, 0)
g1.addEdge(1, 2)
g1.addEdge(2, 3)
g1.addEdge(2, 4)
g1.addEdge(3, 4)
g1.addEdge(4, 3)
print ("Fuertemente conectados ")
g1.SCC()
