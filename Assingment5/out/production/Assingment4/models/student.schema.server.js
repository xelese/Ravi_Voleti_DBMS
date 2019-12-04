const mongoose = require('mongoose');
const studentSchema =
    mongoose.Schema({
                        _id: Number,
                        username: String,
                        password: String,
                        firstName: String,
                        lastName: String,
                        gradYear: Number,
                        scholarship: Number
                    }, {collection: 'students'});

// one to many
/*
const answerWidgetSchema = mongoose.Schema({
                                               answer: [{
                                                   type: mongoose.Schema.Types.ObjectId,
                                                   ref: 'AnswerModel'
                                               }]
                                           }, {collection: 'student-answers'})
*/

module.exports = studentSchema;