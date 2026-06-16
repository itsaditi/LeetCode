# Last updated: 6/15/2026, 10:35:46 PM
adj = collections.defaultdict(list)
for word in wordList:
    for i in range(len(word)):
        adj[word[:i] + '_' + word[i+1:]].append(word)
visited = set()
q = collections.deque([(beginWord, 1)])
while q:
    word, k = q.popleft()
    if word == endWord:
        return k
    if word not in visited:
        visited.add(word)
        for i in range(len(word)):
            neighbors = word[:i] + '_' + word[i+1:]
            for neighbor in adj[neighbors]:
                q.append((neighbor, k+1))
return 0