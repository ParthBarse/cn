g = {
        'A': {'B': 1, 'C': 4, 'D': 2},
        'B': {'A': 9, 'E': 5},
        'C': {'A': 4, 'F': 15},
        'D': {'A': 10, 'F': 7},
        'E': {'B': 3, 'J': 7},
        'F': {'C': 11, 'D': 14, 'K': 3, 'G': 9},
        'G': {'F': 12, 'I': 4},
        'H': {'J': 13},
        'I': {'G': 6, 'J': 7},
        'J': {'H': 2, 'I': 4},
        'K': {'F': 6}
    }

s = 'A'
sp = pn = {}
sp[s] = 0
unvisited = list(g)

while unvisited:
    cur = None
    for node in unvisited:
        if node in sp:
            if cur is None or sp[node] < sp[cur]:
                cur = node
    if cur is None:
        break
    unvisited.remove(cur)
    for n, w in g[cur].items():
        t = sp[cur] + w
        if t < sp.get(n, float('inf')):
            sp[n] = t
            pn[n] = cur

e = 'H'
path = []
while e:
    path.insert(0, e)
    e = pn.get(e)

print('Shortest path from A to the ending node:')

for i in path[::-1]:
    print(i, end="<-")
