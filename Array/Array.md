# 数组 Array

## Basic Array

Array 可能是我们最先接触到的数据结构。
Array 是非常简单的线性存储结构，所谓的 multi-dimensional array 的实际形态也是线性的。

在使用 array 的时候，我们就是向系统索取了一定量的连续内存空间。在 C 语言中，声明数组之后得到的就是第一个
内存地址。 对内存空间之内的内容我们都可以直接的进行各类操作。 所以数组的优点就是对于数组内的任意位置进行直接操作。

由此，我们可以得到几个常见 array 操作的复杂度：

- Add First: $O(n)$. 在向头部添加元素时，要将原来的已有的每一个元素向后位移。
- Add Last: $O(1)$. 直接的尾部添加元素，没有其他的操作需求。
- Add in given index: $O(n)$. 不能确定添加的位置，期望上来说需要复制移动的元素数量是$n/2$。
- Delete First: $O(n)$. 需要将剩余的元素向前位移。
- Delete Last: $O(1)$. 直接删除最后一位元素。
- Delete given index: $O(n)$. 需要将指定 index 右侧的元素左移一位。
- Get value of given index: $O(1)$. Random access 是 Array 的长处。
- Get index of given value: $O(n)$. 需要挨个对比。

## Dynamic Array

因为 array 的空间大小是提前指定的，其大小就制约了我们对数组的使用。为了应对这个问题，我们可以建立一个
动态数组，让它根据数组内元素数量的变动自己对内存空间进行伸缩。

在进行空间调整的时候也十分简单：

1. 按照我们的需求，索取一个新的 array
2. 将原 array 中的元素复制到新的 array 中去
3. 将原 array 的空间释放

我们将这个过程作成一个 `resize` 的函数，然后添加到其他对 array 进行操作的函数中就可以了。

因为 `resize` 要复制 array 中的元素，所以其复杂度为 $O(n)$。但根据空间调整的临界值和新空间的大小，
实际使用时的复杂度会有很大的不同。

首先，不建议将新添加或缩小的空间值定为一个常量。因为我们不知道 array 本身的 size 有多大，一个常量对于
原本的 size 来说很可能是不实用的。比如，array 有 10,000 个元素，我们 resize 的时候每次只增加 10
个位置，那么我们就可能经常需要进行 `resize`，其效率就大打折扣。

通常新空间的大小会是原空间大小的倍数。假设我们设定：

- 当 array 满时，大小扩充为现在大小的 2 倍
- 当 array 的元素数量小于空间的 1/4 时，大小缩小为现在的 1/2

这么设定有两个好处。第一，空间大小的变化和现有元素的实际数量有了相关性，这样会让 `resize` 的实际复杂度
降低许多。假如初始空间大小 capacity 是 10，我们要连续进行 11 次的 `add first` 的操作才需要一次 `resize`。
平均下来 `resize` 的复杂度就均摊到了 `add first` 中，成了$O(1)$.

第二，增加和缩减 capacity 的临界值不同，避免复杂度震荡。想象一下，如果 array 在元素数量小于 capacity
的 1/2 的时候就进行空间调整的话，万一在临界值处重复进行 `add` 和 `delete`， 我们就会不断的进行
`resize` 操作，整个复杂度就大大提高了。