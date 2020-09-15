delete
from ucollection
where true;

delete
from theme
where true;

INSERT INTO collectionsm.ucollection (id, description, image, name)
values (1, 'Very well',
        'https://media.istockphoto.com/photos/playing-cards-isolated-on-white-with-clipping-path-picture-id628518338?k=6&m=628518338&s=612x612&w=0&h=askN5CnKvPb2hABLHvqRZbkSDC8vmcNWqY7uNnLIR2Y=',
        'Monet'),
       (2, 'Very good description',
        'https://media.istockphoto.com/photos/playing-cards-isolated-on-white-with-clipping-path-picture-id628518338?k=6&m=628518338&s=612x612&w=0&h=askN5CnKvPb2hABLHvqRZbkSDC8vmcNWqY7uNnLIR2Y=',
        'Табак'),
       (3, 'Very good description',
        'https://media.istockphoto.com/photos/playing-cards-isolated-on-white-with-clipping-path-picture-id628518338?k=6&m=628518338&s=612x612&w=0&h=askN5CnKvPb2hABLHvqRZbkSDC8vmcNWqY7uNnLIR2Y=',
        'Табак'),
       (4, 'Very good description',
        'https://media.istockphoto.com/photos/playing-cards-isolated-on-white-with-clipping-path-picture-id628518338?k=6&m=628518338&s=612x612&w=0&h=askN5CnKvPb2hABLHvqRZbkSDC8vmcNWqY7uNnLIR2Y=',
        'Табак'),
       (5, 'Very good description',
        'https://media.istockphoto.com/photos/playing-cards-isolated-on-white-with-clipping-path-picture-id628518338?k=6&m=628518338&s=612x612&w=0&h=askN5CnKvPb2hABLHvqRZbkSDC8vmcNWqY7uNnLIR2Y=',
        'Табак'),
       (6, 'Very good description',
        'https://media.istockphoto.com/photos/playing-cards-isolated-on-white-with-clipping-path-picture-id628518338?k=6&m=628518338&s=612x612&w=0&h=askN5CnKvPb2hABLHvqRZbkSDC8vmcNWqY7uNnLIR2Y=',
        'Табак'),
       (7, 'Very good description',
        'https://media.istockphoto.com/photos/playing-cards-isolated-on-white-with-clipping-path-picture-id628518338?k=6&m=628518338&s=612x612&w=0&h=askN5CnKvPb2hABLHvqRZbkSDC8vmcNWqY7uNnLIR2Y=',
        'Табак'),
       (8, 'Very good description',
        'https://media.istockphoto.com/photos/playing-cards-isolated-on-white-with-clipping-path-picture-id628518338?k=6&m=628518338&s=612x612&w=0&h=askN5CnKvPb2hABLHvqRZbkSDC8vmcNWqY7uNnLIR2Y=',
        'Табак');


INSERT INTO theme(id, name)
VALUES (1, 'ALCOHOL'),
       (2, 'CARDS'),
       (3, 'MONEY');
