const questionModel = require("../models/question.model.server")
const answerModel = require("../models/answer.model.server")
const studentModel = require("../models/student.model.server")

// create.
createStudent = student => studentModel.create(student)
createQuestion = question => questionModel.create(question);
createAnswer = answer => answerModel.create(answer);

//find by id
findStudentById = studentId => studentModel.findById(studentId)
findAnswerById = answerId => answerModel.findById(answerId)
findQuestionById = questionId => questionModel.findById(questionId)

// find all
findAllStudents = () => studentModel.find()
findAllAnswers = () => answerModel.find()
findAllQuestions = () => questionModel.find()

// find specifics
findAnswerByStudent = studentId => answerModel.find({student: studentId});
findAnswerByQuestion = questionId => answerModel.find({question: questionId});

//delete
deleteStudent =
    studentId => studentModel.remove({_id: studentId}).then(result => console.log(result));
deleteQuestion =
    questionId => questionModel.remove({_id: questionId}).then(result => console.log(result));
deleteAnswer =
    answerId => answerModel.remove({_id: answerId}).then(result => console.log(result));
deleteAnswerByStudentAndQuestion =
    (sId, q) => answerModel.remove({$and: [{student: sId}, {question: q}]})

// delete all
deleteAllAnswer = () => answerModel.remove({});
deleteAllStudent = () => studentModel.remove({});
deleteAllQuestion = () => questionModel.remove({});

// truncate function.
function truncateDatabase() {
    return Promise.all([deleteAllAnswer(), deleteAllStudent(), deleteAllQuestion()])
}

// answer question function.
function answerQuestion(id, studentId, questionId, answer) {

    if (answer === true || answer === false) {
        return createAnswer({
                                _id: id,
                                student: studentId,
                                question: questionId,
                                trueFalseAnswer: answer,
                            });
    } else {
        return createAnswer({
                                _id: id,
                                student: studentId,
                                question: questionId,
                                multipleChoiceAnswer: answer,
                            });
    }
}

// populate database
function populateDatabase() {

    return Promise.all([createStudent({
                                          _id: 123,
                                          firstName: 'Alice',
                                          lastName: 'Wonderland',
                                          username: 'alice',
                                          password: 'alice',
                                          gradYear: 2020,
                                          scholarship: 15000

                                      }),

                        createStudent({
                                          _id: 234,
                                          firstName: 'Bob',
                                          lastName: 'Hope',
                                          username: 'bob',
                                          password: 'bob',
                                          gradYear: 2021,
                                          scholarship: 12000

                                      }),
                        createQuestion({
                                           _id: 321,
                                           question: 'Is the following schema valid?',
                                           points: 10,
                                           questionType: 'TRUE_FALSE',
                                           trueFalse: {isTrue: false}
                                       }),

                        createQuestion({
                                           _id: 432,
                                           question: 'DAO stands for Dynamic Access Object.',
                                           points: 10,
                                           questionType: 'TRUE_FALSE',
                                           trueFalse: {isTrue: true}
                                       }).then(newUser =>
                                                   console.log(newUser)),

                        createQuestion({
                                           _id: 543,
                                           question: 'What does JPA stand for?',
                                           points: 10,
                                           questionType: 'MULTIPLE_CHOICE',
                                           multipleChoice: {
                                               choices: "Java Persistence API,Java Persisted Application,JavaScript"
                                                        + " Persistence API,JSON Persistent Associations",
                                               correct: 1
                                           }
                                       }).then(newUser =>
                                                   console.log(newUser)),

                        createQuestion({
                                           _id: 654,
                                           question: 'What does OMR stand for?',
                                           points: 10,
                                           questionType: 'MULTIPLE_CHOICE',
                                           multipleChoice: {
                                               choices: "Object Relational Model,Object Relative Markup,Object"
                                                        + " Reflexive Model,Object Relational Mapping",
                                               correct: 4
                                           }
                                       }).then(newUser =>
                                                   console.log(newUser)),

                        answerQuestion(123, 123, 321, true),

                        answerQuestion(234, 123, 432, false),

                        answerQuestion(345, 123, 543, 1),

                        answerQuestion(456, 123, 654, 2),

                        answerQuestion(567, 234, 321, false),

                        answerQuestion(678, 234, 432, true),

                        answerQuestion(789, 234, 543, 3),

                        answerQuestion(890, 234, 654, 4)]
    )

}

module.exports = {
    createStudent,
    findAllStudents,
    findStudentById,
    deleteStudent,
    createQuestion,
    findAllQuestions,
    findQuestionById,
    deleteQuestion,
    findAllAnswers,
    findAnswerById,
    deleteAnswer,
    populateDatabase,
    truncateDatabase,
    findAnswerByQuestion,
    findAnswerByStudent,
    answerQuestion,
    deleteAnswerByStudentAndQuestion
}
