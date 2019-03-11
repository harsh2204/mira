import cherrypy
import logging
from textblob import TextBlob

class Score(object):
    def sentiment(self, string):
        analysis = TextBlob(string)
        return analysis.sentiment.polarity
    def get_score(self, review):
        # review object = [usefulness (), user_rating (x/10), text(-1, 1)]
        score = review['use'] + review['rating'] + sentiment(review['text'])
        return score
    pass