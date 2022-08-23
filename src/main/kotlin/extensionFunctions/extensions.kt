
/*inline fun <reified T : Parcelable> createParcel(
        crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
        object : Parcelable.Creator<T> {
            override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
            override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
        }*/
        
        
/*        
inline
this function at every place that you were using it
t’s like “copy & pasting” this function in all the place that you were using it


reified
access to a type passed as a parameter

crossinline
execute the function passed as parameter in another context
*/
