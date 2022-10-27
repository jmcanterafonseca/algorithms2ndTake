/**
 *   Generic interface for a cache
 */
interface TypedCache<T> {
  put(entry: string, element: T): void;
  get(entry: string): T | undefined;
  exists(entry: string): boolean;
};

/**
 *   Linked List node
 * 
 */
interface ListNode<T> {
  value: T;
  next?: ListNode<T>;
  previous?: ListNode<T>;
};

/**
 *    Double Linked List used to hold a queue (FIFO)
 * 
 */
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

  /**
   *   Adds the node as the last node in the list 
   */
  public add(ele: ListNode<T>): void {
    if (this._first === undefined && this._last === undefined) {
      this._last = this._first = ele;
      return;
    }

    // Insert as the last
    ele.previous = this._last;
    ele.next = undefined;
    if (this._last) {
      this._last.next = ele;
      if (!this._last.previous) {
        this._first = this._last;
      }
    }

    this._last = ele;

    // Now updating the first
    if (!this._first) {
      this._first = ele;
    }
  }

  public print(): void {
    let current = this._first;

    while (current) {
      console.log(current.value);
      current = current.next;
    }
  }

  /**
   *   Removes the Node in the list which value is equal to nodeValue 
   * 
   */
  public removeByValue(nodeValue: T): void {
    if (this._first === undefined && this._last === undefined) {
      return;
    }

    let current: ListNode<T> | undefined = this._first;

    while (current) {
      if (current.value === nodeValue) {
        break;
      }
      current = current.next;
    }

    if (current) {
      this.remove(current);
    }
  }

  /**
   *    Removes an already existing node. The node shall be a healthy node in the list
   * 
   */
  public remove(current: ListNode<T>): void {
    if (this._first === undefined && this._last === undefined) {
      return;
    }

    if (!current) {
      return;
    }

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

// The LRU Cache implementation has a limit in storage 
// The least recently used cached item shall be evicted from the cache
class LRUCache<T> implements TypedCache<T> {
  // The cache keeps both the cached item and the node in the list
  // That way when the LRU List has to be updated we don't need to go through the list to find the node
  private readonly _cacheEntries = new Map<string, { cachedItem: T, listNode: ListNode<string> }>();
  // Maximum number of entries
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

    const listNode: ListNode<string> = { value: entry };
    this._cacheEntries.set(entry, { cachedItem: element, listNode });
    this._linkedList.add(listNode);
  }

  public get(entry: string): T | undefined {
    // As it is now used moves to the tail so it is not evictable
    const element = this._cacheEntries.get(entry);
    let result = undefined;

    if (element) {
      // It is removed from its current place
      this._linkedList.remove(element.listNode);
      // And then added as the last
      this._linkedList.add(element.listNode);
      result = element.cachedItem;
    }

    return result;
  }

  public exists(entry: string): boolean {
    return this._cacheEntries.has(entry);
  }
}



function testLRUCache() {
  const cache = new LRUCache<number>(3);

  cache.put("1", 1);
  cache.put("2", 2);
  cache.put("3", 3);

  console.log(cache.get("1") === 1);

  // This should evict the "2" a the one has been recently used
  cache.put("4", 4);

  console.log(cache.get("1") === 1);
  console.log(cache.get("2") === undefined);

  cache.put("5", 5);
  console.log(cache.get("2") === undefined);
  console.log(cache.get("3") === undefined);

  console.log(cache.get("4") === 4);
  console.log(cache.get("5") === 5);
  console.log(cache.get("1") === 1);
}

function testLinkedList() {
  const linkedList = new DoubleLinkedList<string>();

  console.log(linkedList.first() === undefined);
  console.log(linkedList.last() === undefined);

  let node: ListNode<string> = { value: "hello" };
  linkedList.add(node);

  console.log(linkedList.first() === linkedList.last());
  console.log(linkedList.first() === node);


  linkedList.add({ value: "world" });

  console.log(linkedList.first()?.value === "hello");
  console.log(linkedList.last()?.value === "world");

  linkedList.removeByValue("hello");

  console.log(linkedList.last()?.value === "world");
  console.log(linkedList.first()?.value === "world");
  
  linkedList.removeByValue("hello");
  linkedList.removeByValue("world");

  console.log(linkedList.first() === undefined);
  console.log(linkedList.first() === linkedList.last());

  node = { value: "kk" };
  linkedList.add(node);
  linkedList.remove(node);

  console.log(linkedList.first() === linkedList.last());
  console.log(linkedList.last() === undefined);
}

testLinkedList();
testLRUCache();
