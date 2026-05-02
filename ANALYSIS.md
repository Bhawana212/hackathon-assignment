### 1. Cause of ConcurrentModificationException
It occurs when a collection is modified while iterating over it using an iterator.

### 2. Likely Code Pattern
for (Transaction t : list) {
    list.remove(t);
}

### 3. Fix
Use Iterator:

Iterator<Transaction> it = list.iterator();
while (it.hasNext()) {
    Transaction t = it.next();
    if (condition) {
        it.remove();
    }
}
