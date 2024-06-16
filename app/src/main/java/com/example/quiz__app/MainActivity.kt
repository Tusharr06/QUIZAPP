package com.example.quiz__app

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val questions = arrayOf(
            "What does CPU stand for?",
            "Which company developed the Windows operating system?",
            "What is the primary purpose of RAM in a computer?",
            "What is the full form of HTML?",
            "Which type of memory is non-volatile?",
            "What does GPU stand for?",
            "Who is known as the father of computers?",
            "What is the name of the main circuit board in a computer?",
            "Which company is known for its 'ThinkPad' laptops?",
            "What is the main function of an operating system?",
            "Which programming language is primarily used for web development?",
            "What does SSD stand for in computer terms?",
            "Which device is used to connect a computer to a network?",
            "What is the full form of USB?",
            "Which company manufactures the 'MacBook'?",
            "What is the main purpose of a firewall in a computer network?",
            "Which programming language is known for its use in data science?",
            "What does BIOS stand for?",
            "Which part of a computer is responsible for executing instructions?",
            "What is an IP address used for?",
            "Which company is known for its 'GeForce' graphics cards?",
            "What does HTTP stand for?",
            "What is the name of the software that allows users to view web pages?",
            "Which type of malware is designed to replicate itself?",
            "Which company created the Linux operating system?"
        )

// 2D array of options
        val options = arrayOf(
            arrayOf("Central Processing Unit", "Central Programming Unit", "Central Progressive Unit", "Central Printing Unit"),
            arrayOf("Apple", "Microsoft", "IBM", "Google"),
            arrayOf("Store data permanently", "Process data", "Store data temporarily", "Control hardware"),
            arrayOf("HyperText Markup Language", "HyperText Machine Language", "HyperText and Links Markup", "Hyper Tool Markup Language"),
            arrayOf("RAM", "Cache", "ROM", "Registers"),
            arrayOf("General Processing Unit", "Graphical Performance Unit", "Graphics Processing Unit", "Graphical Programming Unit"),
            arrayOf("Bill Gates", "Steve Jobs", "Charles Babbage", "Alan Turing"),
            arrayOf("Motherboard", "Fatherboard", "Breadboard", "Powerboard"),
            arrayOf("Dell", "HP", "Lenovo", "Asus"),
            arrayOf("Manage hardware and software resources", "Perform calculations", "Connect to the internet", "Run applications"),
            arrayOf("Python", "Java", "JavaScript", "C++"),
            arrayOf("Solid State Drive", "Solid State Disk", "Semi-State Disk", "Semi-State Drive"),
            arrayOf("Router", "Monitor", "Printer", "Scanner"),
            arrayOf("Universal Serial Bus", "Universal Service Bus", "Uniform Serial Bus", "Uniform Service Bus"),
            arrayOf("Dell", "Microsoft", "Apple", "Lenovo"),
            arrayOf("To monitor network traffic", "To prevent unauthorized access", "To store data", "To enhance system performance"),
            arrayOf("Python", "C#", "JavaScript", "Ruby"),
            arrayOf("Basic Input Output System", "Binary Input Output System", "Basic Internal Output System", "Binary Internal Output System"),
            arrayOf("Hard Drive", "Motherboard", "Processor", "Power Supply"),
            arrayOf("To identify devices on a network", "To store data", "To execute programs", "To display images"),
            arrayOf("AMD", "Intel", "NVIDIA", "ASUS"),
            arrayOf("HyperText Transfer Protocol", "HyperText Transmission Protocol", "HyperTool Transfer Protocol", "HyperTool Transmission Protocol"),
            arrayOf("Browser", "Compiler", "Operating System", "IDE"),
            arrayOf("Virus", "Worm", "Trojan", "Adware"),
            arrayOf("Linus Torvalds", "Bill Gates", "Steve Jobs", "Dennis Ritchie")
        )

// Array of correct option indices
        val correctans = arrayOf(0, 1, 2, 0, 2, 2, 2, 0, 2, 0, 2, 0, 0, 0, 2, 1, 0, 0, 2, 0, 2, 0, 0, 1, 0)

        var questionind = 0
        var score = 0
        var text = findViewById<TextView>(R.id.textView)
        var btn1 = findViewById<Button>(R.id.button)
        var btn2 = findViewById<Button>(R.id.button1)
        var btn3 = findViewById<Button>(R.id.button2)
        var btn4 = findViewById<Button>(R.id.button3)
        var btn5 = findViewById<Button>(R.id.button4)


        fun resetclrs() {
            btn1.setBackgroundColor(Color.WHITE)
            btn2.setBackgroundColor(Color.WHITE)
            btn3.setBackgroundColor(Color.WHITE)
            btn4.setBackgroundColor(Color.WHITE)
            btn5.setBackgroundColor(Color.WHITE)
        }
        fun displayquestion() {
            text.text = questions[questionind]
            btn1.text = options[questionind][0]
            btn2.text = options[questionind][1]
            btn3.text = options[questionind][2]
            btn5.text=options[questionind][3]
            resetclrs()
        }


        displayquestion()
        fun buttonright(buttonidex: Int) {
            when (buttonidex) {
                0 -> btn1.setBackgroundColor(Color.GREEN)
                1 -> btn2.setBackgroundColor(Color.GREEN)
                2 -> btn3.setBackgroundColor(Color.GREEN)
                3 ->btn5.setBackgroundColor(
                    Color.GREEN
                )

            }
        }

        fun buttonwrong(buttonidex: Int) {
            when (buttonidex) {
                0 -> btn1.setBackgroundColor(Color.RED)
                1 -> btn2.setBackgroundColor(Color.RED)
                2 -> btn3.setBackgroundColor(Color.RED)
                3 ->btn5.setBackgroundColor(Color.RED)
            }
        }




        fun shoresults() {


            fun showdialouge(score:Int) {
                var dialog = Dialog(this)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setContentView(R.layout.score_dialouge)
                dialog.show()


                var txt3 = dialog.findViewById<TextView>(R.id.textView3)
                var per = ((score.toFloat()/questions.size.toFloat())*100).toInt()
                txt3.text=score.toString()
                when(per)

                {

                    in 0..34 ->txt3.setTextColor(Color.RED)
                    in 35..100->txt3.setTextColor(Color.GREEN)


                }


            }
            showdialouge(score)

            btn4.isEnabled = true
        }
        fun checkanswers(selectanswerIndex: Int) {
            val correctanswerindex = correctans[questionind]
            if (selectanswerIndex == correctanswerindex) {
                score++
                buttonright(selectanswerIndex)
            } else {
                buttonwrong(selectanswerIndex)
                buttonright(correctanswerindex)
            }
            if (questionind < questions.size - 1) {
                questionind++
                text.postDelayed({ displayquestion() }, 1000)
            } else {
                btn4.isEnabled=true
                shoresults()

            }
        }
        btn1.setOnClickListener {
            checkanswers(0)
        }
        btn2.setOnClickListener {
            checkanswers(1)
        }
        btn3.setOnClickListener {
            checkanswers(2)
        }
        btn5.setOnClickListener {
            checkanswers(3)
        }


        fun restartquiz() {
            questionind = 0
            score = 0
            btn4.isEnabled = false
            displayquestion()
        }
        btn4.setOnClickListener {
            restartquiz()
        }

    }


}
