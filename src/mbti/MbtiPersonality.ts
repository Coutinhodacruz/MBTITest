// @ts-ignore
import * as readlineSync from 'readline-sync';

const NUM_QUESTIONS = 20;

const QUESTIONS: string[] = [
    'I enjoy socializing at parties.',
    'I prefer to spend time alone rather than with a group of people.',
    'I often try new things just for the experience.',
    'I prefer to have a few close friends rather than many acquaintances.',
    'I like to carefully plan my activities in advance.',
    'I am more energetic and enthusiastic than calm and reserved.',
    'I often feel overwhelmed by emotions.',
    'I value logic and rational thinking over emotions and feelings.',
    'I enjoy going to social events and meeting new people.',
    'I find it draining to be around a lot of people for long periods.',
    'I am often the one to start a conversation with others.',
    'I am a private person and don\'t share much about myself.',
    'I like to follow a schedule and dislike unexpected changes.',
    'I am adaptable and go with the flow.',
    'I trust my instincts and feelings more than facts and evidence.',
    'I enjoy discussing various topics with different people.',
    'I need some time alone to recharge after socializing.',
    'I am detail-oriented and notice small changes.',
    'I prefer to work in a quiet and focused environment.',
    'I enjoy taking risks and trying new things.'
];

const TRAIT_DESCRIPTIONS: string[] = [
    'Introverted (I) - Reserved, reflective, and thoughtful.',
    'Extroverted (E) - Outgoing, energetic, and expressive.',
    'Intuitive (N) - Imaginative, open-minded, and curious.',
    'Observant (S) - Practical, realistic, and focused on details.',
    'Thinking (T) - Logical, objective, and analytical.',
    'Feeling (F) - Empathetic, compassionate, and values emotions.',
    'Judging (J) - Organized, planned, and decisive.',
    'Perceiving (P) - Flexible, spontaneous, and adaptable.'
];

function getUserResponse(): string {
    let response: string;
    do {
        response = readlineSync.question('Select A or B: ').toUpperCase();
    } while (response !== 'A' && response !== 'B');
    return response;
}

function calculatePersonalityTrait(responses: string[]): string {
    let countA = 0;
    let countB = 0;

    for (const response of responses) {
        if (response === 'A') {
            countA++;
        } else {
            countB++;
        }
    }

    // Personality trait determination
    let trait = '';
    trait += countA > countB ? 'I' : 'E';
    trait += responses[4] === 'B' ? 'S' : 'N';
    trait += responses[8] === 'B' ? 'T' : 'F';
    trait += responses[12] === 'B' ? 'J' : 'P';

    return trait;
}

function getTraitDescription(personalityTrait: string): string {
    let description = '';

    for (const trait of personalityTrait) {
        switch (trait) {
            case 'I':
                description += TRAIT_DESCRIPTIONS[0] + ' ';
                break;
            case 'E':
                description += TRAIT_DESCRIPTIONS[1] + ' ';
                break;
            case 'N':
                description += TRAIT_DESCRIPTIONS[2] + ' ';
                break;
            case 'S':
                description += TRAIT_DESCRIPTIONS[3] + ' ';
                break;
            case 'T':
                description += TRAIT_DESCRIPTIONS[4] + ' ';
                break;
            case 'F':
                description += TRAIT_DESCRIPTIONS[5] + ' ';
                break;
            case 'J':
                description += TRAIT_DESCRIPTIONS[6] + ' ';
                break;
            case 'P':
                description += TRAIT_DESCRIPTIONS[7] + ' ';
                break;
        }
    }

    return description.trim();
}

function main(): void {
    console.log('Welcome to the MBTI Personality Test!');

    // Collect user's name
    const userName: string = readlineSync.question('Enter your name: ');

    console.log(`Welcome, ${userName}, to the MBTI Personality Test!\n`);

    const userResponses: string[] = [];

    for (let i = 0; i < NUM_QUESTIONS; i++) {
        console.log(`Q${i + 1}: ${QUESTIONS[i]}`);
        const response = getUserResponse();
        userResponses.push(response);
    }

    // Calculate personality trait based on user responses
    const personalityTrait = calculatePersonalityTrait(userResponses);

    // Display results
    console.log('\nUser Responses:');
    for (let i = 0; i < NUM_QUESTIONS; i++) {
        console.log(`Q${i + 1}: ${userResponses[i]}`);
    }

    console.log(`\nPersonality Trait: ${personalityTrait}`);
    console.log(`Trait Description: ${getTraitDescription(personalityTrait)}`);
}

// Run the main function
main();
