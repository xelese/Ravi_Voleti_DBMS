const mongoose = require('mongoose')

const quizWidgetSchema = require('./quiz-widget.schema.server.js')

const quizWidgetModel = mongoose.model('QuizWdgetModel', quizWidgetSchema);

module.exports = quizWidgetModel