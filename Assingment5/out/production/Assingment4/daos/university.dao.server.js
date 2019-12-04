const studentModel = require("../models/student.model.server")

const questionModel = require("../models/question.model.server")

const answerModel = require("../models/answer.model.server")

// Student.
createStudent = student => studentModel.create(student)

findAllStudents = () => studentModel.find()

findStudentById = studentId => studentModel.findById(studentId)

deleteStudent = studentId => studentModel.remove({_id: studentId}).then(console.log)

deleteAllStudent = () => studentModel.remove({}).then(console.log)

// Question.
createQuestion = question => questionModel.create(question);

findAllQuestions = () => questionModel.find()

findQuestionById = questionId => questionModel.findById(questionId)

deleteQuestion = questionId => questionModel.remove({_id: questionId})

deleteAllQuestion = () => questionModel.remove({}).then(console.log)

// Answer.
createAnswer = answer => answerModel.create(answer);

findAllAnswers = () => answerModel.find()

findAnswerById = answerId => answerModel.findById(answerId)

deleteAnswer = answerId => answerModel.remove({_id: answerId})

deleteAllAnswer = () => answerModel.remove({}).then(console.log)

findAnswerByStudent = studentId => answerModel.findById(studentId)

findAnswerByQuestion = questionId => answerModel.findById(questionId)

function truncateDatabase() {
    deleteAllAnswer();
    deleteAllStudent();
    deleteAllQuestion();
}

function answerQuestion(studentId, questionId, answer) {

    if (answer === typeof (Boolean)) {
        createAnswer({
                         student: studentId,
                         question: questionId,
                         trueFalseAnswer: answer,
                     }).then(newUser =>
                                 console.log(newUser));
    } else {
        createAnswer({
                         student: studentId,
                         question: questionId,
                         multipleChoiceAnswer: answer,
                     }).then(newUser =>
                                 console.log(newUser));
    }
    /*createAnswer({
                     _id: 123,
                     student: 123,
                     question: 321,
                     trueFalseAnswer: true,
                 }).then(newUser =>
                             console.log(newUser));

    createAnswer({
                     _id: 234,
                     student: 123,
                     question: 432,
                     trueFalseAnswer: false,
                 }).then(newUser =>
                             console.log(newUser));

    createAnswer({
                     _id: 345,
                     student: 123,
                     question: 543,
                     multipleChoiceAnswer: 1
                 }).then(newUser =>
                             console.log(newUser));

    createAnswer({
                     _id: 456,
                     student: 123,
                     question: 654,
                     multipleChoiceAnswer: 2
                 }).then(newUser =>
                             console.log(newUser));

    createAnswer({
                     _id: 567,
                     student: 234,
                     question: 321,
                     trueFalseAnswer: false,
                 }).then(newUser =>
                             console.log(newUser));

    createAnswer({
                     _id: 678,
                     student: 234,
                     question: 432,
                     trueFalseAnswer: true,
                 }).then(newUser =>
                             console.log(newUser));

    createAnswer({
                     _id: 789,
                     student: 234,
                     question: 543,
                     multipleChoiceAnswer: 3
                 }).then(newUser =>
                             console.log(newUser));

    createAnswer({
                     _id: 890,
                     student: 234,
                     question: 654,
                     multipleChoiceAnswer: 4
                 }).then(newUser => console.log(newUser));
*/
}

function populate() {

    createStudent({
                      _id: 123,
                      firstName: 'Alice',
                      lastName: 'Wonderland',
                      username: 'alice',
                      password: 'alice',
                      gradYear: 2020,
                      scholarship: 15000

                  }).then(newUser =>
                              console.log(newUser));

    createStudent({
                      _id: 234,
                      firstName: 'Bob',
                      lastName: 'Hope',
                      username: 'bob',
                      password: 'bob',
                      gradYear: 2021,
                      scholarship: 12000

                  }).then(newUser =>
                              console.log(newUser));

    createQuestion({
                       _id: 321,
                       question: 'Is the following schema valid?',
                       points: 10,
                       questionType: 'TRUE_FALSE',
                       trueFalse: {isTrue: false}
                   }).then(newUser =>
                               console.log(newUser));

    createQuestion({
                       _id: 432,
                       question: 'DAO stands for Dynamic Access Object.',
                       points: 10,
                       questionType: 'TRUE_FALSE',
                       isTrue: {isTrue: true}
                   }).then(newUser =>
                               console.log(newUser));

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
                               console.log(newUser));

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
                               console.log(newUser));

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
                               console.log(newUser));
}

// test suite
function testStudentInitialCount() {
    studentModel.count().then(result => console.log());
}

function testQuestionInitialCount() {
    questionModel.count().then(result => console.log());
}

function testAnswerInitialCount() {
    answerModel.count().then(result => console.log());
}

function testDeleteAnswer() {
    answerModel.count().then(result => console.log());
}

//TODO 6,7,8 insert answer and question, many to many.

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
    populate,
    truncateDatabase,
    deleteAllStudent,
    deleteAllAnswer,
    deleteAllQuestion,
    findAnswerByQuestion,
    findAnswerByStudent,
    answerQuestion,
    testAnswerInitialCount,
    testQuestionInitialCount,
    testStudentInitialCount
}
