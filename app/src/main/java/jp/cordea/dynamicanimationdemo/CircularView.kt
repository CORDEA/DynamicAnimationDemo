package jp.cordea.dynamicanimationdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.dynamicanimation.animation.SpringAnimation

class CircularView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint().apply {
        style = Paint.Style.FILL
        isAntiAlias = true
        color = ContextCompat.getColor(context, R.color.colorAccent)
    }

    fun startAnimation(
        stiffness: Float,
        dampingRatio: Float
    ) {
        scaleX = 1.5f
        SpringAnimation(this, SpringAnimation.SCALE_X, 1f).apply {
            spring.stiffness = stiffness
            spring.dampingRatio = dampingRatio
        }.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas ?: return
        canvas.drawCircle(width / 2f, height / 2f, width / 2f, paint)
    }
}
