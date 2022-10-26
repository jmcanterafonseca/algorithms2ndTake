interface TypedCache<T> {
  put(entry: string, element: T): void;
  get(entry: string): T | undefined;
  exists(entry: string): boolean;
};

// The LRU Cache implementation has a limit in storage

class LRUCache<T> implements TypedCache<T> {
  private readonly _cacheEntries = new Map<string, T>();
  private readonly _size: number;
  private readonly _linkedList = new DoubleLinkedList<string>();

  /**
   *   Maximum size of the cache
   *   If maximum size is exceeded then elements will be evicted
   */
  constructor(size: number) {
    this._size = size;
  }

  public put(entry: string, element: T): void {
    if (this._size === this._cacheEntries.size) {
      // It is needed to evict an entry
      const toEvict = this._linkedList.first();
      if (toEvict) {
        this._cacheEntries.delete(toEvict.value);
        this._linkedList.remove(toEvict);
      }
    }

    this._cacheEntries.set(entry, element);
    this._linkedList.moveToLast({ value: entry });

    // console.log(this._linkedList.first());
    // console.log(this._linkedList.last());

    // this._linkedList.print();
  }

  public get(entry: string): T | undefined {
    // As it is now used moves to the tail so it is not evictable
    if (this._cacheEntries.has(entry)) {
      this._linkedList.moveToLast({ value: entry });
    }

    return this._cacheEntries.get(entry);
  }

  public exists(entry: string): boolean {
    return this._cacheEntries.has(entry);
  }
}

class DoubleLinkedList<T> {
  // the first in the list will be the older one
  private _first: ListNode<T> | undefined = undefined;
  // The last is the most recently used (the one just being used)
  private _last: ListNode<T> | undefined = undefined;

  // The element at the head of the list will be the first to be evicted
  public first(): ListNode<T> | undefined {
    return this._first;
  }

  // Last element to be evicted
  public last(): ListNode<T> | undefined {
    return this._last;
  }

  public moveToLast(ele: ListNode<T>): void {
    if (this._first === undefined && this._last === undefined) {
      this._last = this._first = ele;
      return;
    }

    // Removing
    this.remove(ele);

    const eleC = JSON.parse(JSON.stringify(ele));

    // Insert as the last
    eleC.previous = this._last;
    eleC.next = undefined;
    if (this._last) {
      this._last.next = eleC;
      if (!this._last.previous) {
        this._first = this._last;
      }
    }

    this._last = eleC;

    // Now updating the first
    if (!this._first) {
      this._first = eleC;
    }
  }

  public print(): void {
    let current = this._first;

    while (current) {
      console.log(current.value);
      current = current.next;
    }
  }

  public remove(node: ListNode<T>) {
    if (this._first === undefined && this._last === undefined) {
      return;
    }

    let current: ListNode<T> | undefined = this._first;

    while (current) {
      if (current.value === node.value) {
        break;
      }
      current = current.next;
    }

    if (current) {
      if (current.previous) {
        current.previous.next = current.next;
      }
      else {
        // We need to update the first
        this._first = current.next;
      }

      if (current.next) {
        current.next.previous = current.previous;
      }
      else {
        this._last = current.previous;
      }
    }
  }

}

interface ListNode<T> {
  value: T;
  next?: ListNode<T>;
  previous?: ListNode<T>;
}

/*
const cache = new LRUCache<number>(3);

cache.put("1", 1);
cache.put("2", 2);
cache.put("3", 3);

cache.get("1");

// This should evict the "2" a the one has been recently used
cache.put("4", 4);
cache.put("5", 4);

console.log(cache.get("1"));
console.log(cache.get("2"));
*/

const linkedList = new DoubleLinkedList<string>();

console.log(linkedList.first());
console.log(linkedList.last());

linkedList.moveToLast({ value: "hello" });
console.log(linkedList.first() === linkedList.last());

linkedList.moveToLast({ value: "world" });

console.log(linkedList.first()?.value === "hello");
console.log(linkedList.last()?.value === "world");
linkedList.remove({value: "hello"});
console.log(linkedList.last()?.value === "world");
console.log(linkedList.first()?.value === "world");
linkedList.remove({value: "hello"});
linkedList.remove({value: "world"});

console.log(linkedList.first() === undefined);
console.log(linkedList.first() === linkedList.last());

linkedList.moveToLast({value: "kk" });
linkedList.remove({value: "kk" });

console.log(linkedList.first() === linkedList.last());
console.log(linkedList.last());
