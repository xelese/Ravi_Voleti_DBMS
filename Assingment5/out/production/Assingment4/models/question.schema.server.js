const mongoose = require('mongoose')

// inheritance.
const TrueFalseSchema = require('./true-false.schema.server.js')
const MultipleChoiceSchema = require('./multiple-choice.schema.server.js')

/*// one to many
const answerWidgetSchema = mongoose.Schema({
                                               answer: [{
                                                   type: mongoose.Schema.Types.ObjectId,
                                                   ref: 'AnswerModel'
                                               }]
                                           }, {collection: 'question-answers'})*/

module.exports = mongoose.Schema({
                                      _id: Number,
                                      question: String,
                                      points: Number,
                                      questionType: String,
                                      multipleChoice: MultipleChoiceSchema,
                                      trueFalse: TrueFalseSchema
                                  }, {collection: 'questions'})