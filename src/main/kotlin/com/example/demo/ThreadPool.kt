package com.example.demo

import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue

class ThreadPool(
    numberOfThreads: Int
) : Executor {

    private val threadList = LinkedList<WorkerThread>()

    private val taskQueue = LinkedBlockingQueue<Runnable>()

    init {
        if (numberOfThreads < 1 || numberOfThreads > 5)
            throw IllegalArgumentException("Мин. кол-во потоков - 1, макс. - 5")
        for (i in 0 until numberOfThreads) {
            val thread = WorkerThread(taskQueue)
            threadList.add(thread)
            thread.start()
        }
    }

    override fun execute(command: Runnable) {
        synchronized(taskQueue) {
            taskQueue.offer(command)
            (taskQueue as Object).notify()
        }
    }

    fun shutdown() {
        for (i in 0 until threadList.size) {
            threadList[i].interrupt()
        }
    }
}
