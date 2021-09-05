package com.wx.exercise.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * author: DomeOfHeaven
 * date : 2021/1/27
 * desc :
 */
class PieChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object {
        private const val  RADIOUS = 300
    }

    private lateinit var mRect: RectF
    private var mPaint: Paint = Paint().apply {
        isAntiAlias = true

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mRect = RectF(width / 2.0f - RADIOUS, height / 2.0f - RADIOUS, width / 2.0f + RADIOUS, height / 2.0f + RADIOUS);
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawArc(mRect,0f, 80f, true, mPaint)
    }

}