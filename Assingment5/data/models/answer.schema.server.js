const mongoose = require('mongoose');

const student = require('./student.schema.server')
const question = require('./question.schema.server')

const answerSchema =
    mongoose.Schema({
                        _id: Number,
                        trueFalseAnswer: Boolean,
                        multipleChoiceAnswer: Number,
                        student: {
                            ref: 'studentModel',
                            type: mongoose.Schema.Types.Number
                        },
                        question: {
                            ref: 'questionModel',
                            type: mongoose.Schema.Types.Number
                        }
                    }, {collection: 'answer'});


module.exports = answerSchema;