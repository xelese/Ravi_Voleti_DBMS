const mongoose = require('mongoose');

const questionSchema = require('./question.schema.server');

const studentModel = mongoose.model('QuestionModel', questionSchema);

module.exports = studentModel;