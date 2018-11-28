# kotlonic

A set of Kotlin utils for primary objects.

## Assertions

## CharArray (in other way, Strings)

## Collections

**`and` Operator**:

**NOTE: The order of items is not respected**

```kotlin
val collection1 = listOf(1, 2, 3, 4, 5, 6, 7)
val collection2 = listOf(4, 5, 6, 7, 8, 9, 0)

println(collection1 and collection2) // [4, 5, 6, 7]

```

**`or` Operator**:

**NOTE: The order of items is not respected**

```kotlin
val collection1 = listOf(1, 2, 3, 4, 5, 6, 7)
val collection2 = listOf(4, 5, 6, 7, 8, 9, 0)

println(collection1 or collection2) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]

```

**`xor` Operator**:

**NOTE: The order of items is not respected**

```kotlin
val collection1 = listOf(1, 2, 3, 4, 5, 6, 7)
val collection2 = listOf(4, 5, 6, 7, 8, 9, 0)

println(collection1 xor collection2) // [1, 2, 3, 8, 9, 0]

```

## Reflection

## Exceptions
