const mongoose = require('mongoose')

const quizWidgetSchema = require('./quiz-widget.schema.server.js')

module.exports = mongoose.model('quizWidgetModel', quizWidgetSchema)