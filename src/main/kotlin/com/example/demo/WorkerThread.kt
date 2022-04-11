package com.example.demo

import java.util.concurrent.LinkedBlockingQueue

class WorkerThread(
    private val taskQueue: LinkedBlockingQueue<Runnable>
) : Thread() {

    var isStopped = false

    override fun run() {
        while (true) {
            var task: Runnable? = null
            synchronized(taskQueue) {
                if (taskQueue.isEmpty()) {
                    try {
                        (taskQueue as Object).wait()
                    } catch (e: InterruptedException) {
                        isStopped = true
                    }
                }
                if (!isStopped) {
                    task = taskQueue.poll()
                }
            }
            if (isStopped)
                break
            task!!.run()
        }
    }
}
