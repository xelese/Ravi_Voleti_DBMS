require('../data/db')();
const universityDao = require("../data/daos/university.dao.server");

// general test

universityDao.truncateDatabase()

    .then(function () {
        universityDao.populateDatabase()

            .then(result => testStudentInitialCount().then(result => {
                console.assert(2 === result.length)
            }))

            .then(result => testQuestionInitialCount().then(result => {
                console.assert(4 === result.length)
            }))

            .then(result => testAnswerInitialCount().then(result => {
                console.assert(8 === result.length)
            }))

            .then(result => testDeleteAnswer().then(result => {
                universityDao.findAllAnswers().then(result => {
                    console.assert(7 === result.length)
                })
            }))

            .then(result => testDeleteQuestion().then(result => {
                universityDao.findAllQuestions().then(result => {

                    console.assert(3 === result.length)
                })
            }))

            .then(result => testDeleteStudent().then(result => {
                universityDao.findAllStudents().then(result => {

                    console.assert(1 === result.length)
                })
            }))
    }).catch(error => {
    console.log(error)
})

// test suite
function testStudentInitialCount() {
    return universityDao.findAllStudents()
}

function testQuestionInitialCount() {
    return universityDao.findAllQuestions()
}

function testAnswerInitialCount() {
    return universityDao.findAllAnswers()
}

function testDeleteAnswer() {
    return universityDao.deleteAnswerByStudentAndQuestion(234, 654)
}

function testDeleteQuestion() {
    return universityDao.deleteQuestion(321)
}

function testDeleteStudent() {
    return universityDao.deleteStudent(234)
}