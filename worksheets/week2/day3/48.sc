
val x = 90
x: Int
x: AnyVal
x: Any

val y = "abc"
y: String
y: AnyRef
y: Any

val z: Any = if true then x else y

def error() = throw new RuntimeException()

val z2: String = if true then "abc" else error()
val z3: Int = if true then 100 else error()

val z4: String = if true then "abc" else null
val z5: Null = null
val z6 = if true then 100 else null

z2: String
z2.charAt(1)



