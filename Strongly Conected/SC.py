from collections import defaultdict

class Grafo:
  
    # Constructor para nuestros vértices y grafos
    def __init__(self,vertices):
        #Número de vértices
        self.V= vertices 
         
        # Creando el grafo con un contenedor defaultdict tipo lista
        self.grafo = defaultdict(list) 
         
        self.Time = 0
  
    # Añadimos los arcos o Edges
    def addEdge(self,v,w):
        self.grafo[v].append(w)


    # Método para visitar nodos
    def SCCUtil(self,v, low, DF, old, stack):
 
        # Añadir valores DF, low, old e introducir al stack
        DF[v] = self.Time
        low[v] = self.Time
        self.Time += 1
        old[v] = True
        stack.append(v)
 
        # Recorrer grafo adyacente
        for w in self.grafo[v]:
             
            if DF[w] == -1 :

                # Método recursivo de visita
                self.SCCUtil(w, low, DF, old, stack)
 
                # Comparacion de low
                low[v] = min(low[v], low[w])

            # Revisamos si ha sido visitado             
            elif old[w] == True:
                
                low[v] = min(low[v], DF[w])
 
        # Pop de fuertemente conectados
        
        u = -1 #Almacenar fuertemente conectados
        if low[v] == DF[v]:
            # Sacamos los nodos con el mismo valor low
            while u != v:
                u = stack.pop()
                print (u)
                old[u] = False
                 
            print("")


    def SCC(self):
  
        # Marcamos no visitados
        DF = [-1] * (self.V)
        low = [-1] * (self.V)
        old = [False] * (self.V)
        stack =[]
         
 
        # Llamado recursivo para los arcos
        for i in range(self.V):
            if DF[i] == -1:
                self.SCCUtil(i, low, DF, Sack)
